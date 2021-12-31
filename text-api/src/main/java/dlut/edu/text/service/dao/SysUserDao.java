package dlut.edu.text.service.dao;

import dlut.edu.text.integration.mbg.model.SysUser;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/12/31 15:16
 */
public interface SysUserDao {
    /**
     * 找到所有的用户
     * @return
     */
    List<SysUser> getAllUsers();
}
