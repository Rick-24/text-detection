package dlut.edu.text.service.service;

import dlut.edu.text.integration.mbg.model.SysMenu;
import dlut.edu.text.integration.mbg.model.SysRole;
import dlut.edu.text.integration.mbg.model.SysRoleMenu;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/12/31 15:16
 */
public interface SysRoleService extends CurdService<SysRole> {
    /**
     * 查询全部
     * @return
     */
    List<SysRole> findAll();
    
    /**
     * 查询角色菜单集合
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);
    
    /**
     * 保存角色菜单
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);
    
    /**
     * 根据名称查询
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);
}
