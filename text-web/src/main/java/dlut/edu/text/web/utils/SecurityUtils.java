package dlut.edu.text.web.utils;


import dlut.edu.text.web.security.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * Security相关操作
 * @Author : hongwei.zhw
 * @create 2022/1/2 16:14
 */
public class SecurityUtils {
    /**
     * 系统登录认证
     * @param request
     * @param username
     * @param password
     * @param authenticationManager
     * @return
     */
    public static JwtAuthenticationToken login(HttpServletRequest request, String username, String password, AuthenticationManager authenticationManager) {
        JwtAuthenticationToken token = new JwtAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // 执行登录认证过程
        Authentication authentication = authenticationManager.authenticate(token);
        // 认证成功存储认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成令牌并返回给客户端
        token.setToken(JwtTokenUtils.generateToken(authentication));
        return token;
    }

    /**
     * 获取令牌进行认证
     * @param request
     */
    public static void checkAuthentication(HttpServletRequest request) {
        Authentication authentication = JwtTokenUtils.getAuthenticationFromToken(request);
    }

    public static String getUsername(Authentication authentication) {
        String username = null;
        if(authentication !=null){
            Object principal = authentication.getPrincipal();
            if(principal != null && principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            }
        }
        return username;
    }

    public static String getUsername(){
        Authentication authentication = getAuthentication();
        return getUsername(authentication);
    }

    /**
     * 获取当前登录信息
     * @return
     */
    public static Authentication getAuthentication() {
        if(SecurityContextHolder.getContext() == null) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
