package dlut.edu.text.service.dao;

import dlut.edu.text.integration.mbg.model.SysMenu;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/12/31 15:14
 */
public interface SysMenuDao {
    /**
     * 查询菜单树,用户ID和用户名为空则查询全部
     * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @param userName
     * @return
     */
    List<SysMenu> findTree(String userName, int menuType);

    /**
     * 根据用户名查找菜单列表
     * @param userName
     * @return
     */
    List<SysMenu> findByUser(String userName);
}
