package dlut.edu.text.web.security;

import dlut.edu.text.integration.mbg.model.SysUser;
import dlut.edu.text.service.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * 用户登录认证信息查询
 * @Author : hongwei.zhw
 * @create 2022/1/2 15:40
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.getUserByName(username).orElseThrow(() -> new UsernameNotFoundException("该用户不存在"));

        // 用户权限列表，根据用户拥有的权限标识与 如@PreAuthorize 标注的接口对比
        Set<String> permissions = sysUserService.getPermissions(user.getName());
        List<GrantedAuthorityImpl> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(user.getName(),user.getPassword(),user.getSalt(),grantedAuthorities);
    }
}
