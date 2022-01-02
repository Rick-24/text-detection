package dlut.edu.text.web.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import dlut.edu.text.common.result.HttpResult;
import dlut.edu.text.common.result.InvokeResult;
import dlut.edu.text.common.utils.LogUtils;
import dlut.edu.text.integration.mbg.model.SysUser;
import dlut.edu.text.service.service.SysUserService;
import dlut.edu.text.web.security.JwtAuthenticationToken;
import dlut.edu.text.web.utils.PasswordUtils;
import dlut.edu.text.web.utils.SecurityUtils;
import dlut.edu.text.web.vo.LoginBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/2 18:39
 */
@RestController
@Slf4j
public class SysLoginController {

    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        response.setHeader(Constants.KAPTCHA_SESSION_KEY,text);
        log.info("验证码：：：：：：："+ text);
        log.info("session"+request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping("/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException{
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        log.info("验证码：：：：："+ captcha);
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha == null){
            return HttpResult.error("验证码已失效");
        }
        if(!captcha.equals(kaptcha)){
            return HttpResult.error("验证码不正确");
        }
        // 用户信息
        Optional<SysUser> userOptional = sysUserService.getUserByName(username);
        // 账号不存在、密码错误
        if (!userOptional.isPresent()) {
            return HttpResult.error("账号不存在");
        }
        SysUser user = userOptional.get();
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);
    }

}
