package dlut.edu.text.web.security;

import dlut.edu.text.integration.mbg.model.SysUser;
import dlut.edu.text.service.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/12/31 15:47
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SysUser> user = sysUserDao.getUserByName(username);
        if(!user.isPresent()){
            throw new UsernameNotFoundException("该用户不存在");
        }
        //用户权限列表，根据权限标识
        sysUserDao.getPermissions(username);
        return null;
    }
}
