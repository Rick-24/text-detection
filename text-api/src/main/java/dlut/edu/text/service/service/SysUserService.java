package dlut.edu.text.service.service;

import dlut.edu.text.integration.mbg.model.SysUser;
import dlut.edu.text.integration.mbg.model.SysUserRole;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/12/31 15:16
 */
public interface SysUserService extends CrudService<SysUser>{
    /**
     * 找到所有的用户
     * @return
     */
    List<SysUser> getAllUsers();

    /**
     * 查找用户
     * @param username
     * @return
     */
    Optional<SysUser> getUserByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> getPermissions(String userName);

    /**
     * 查找用户的角色集合
     * @param userId
     * @return
     */
    List<SysUserRole> getUserRoles(Long userId);
}
