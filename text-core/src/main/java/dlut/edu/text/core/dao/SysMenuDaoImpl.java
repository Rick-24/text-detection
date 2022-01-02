package dlut.edu.text.core.dao;

import dlut.edu.text.common.consts.SysConstants;
import dlut.edu.text.integration.mbg.mapper.SysMenuMapper;
import dlut.edu.text.integration.mbg.model.SysMenu;
import dlut.edu.text.service.dao.SysMenuDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/2 12:43
 */
@Repository
public class SysMenuDaoImpl implements SysMenuDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<SysMenu> findTree(String userName, int menuType) {
        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = findByUser(userName);
        for (SysMenu menu : menus) {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if (!exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort(Comparator.comparing(SysMenu::getOrderNum));
        findChildren(sysMenus, menus, menuType);
        return sysMenus;
    }

    @Override
    public List<SysMenu> findByUser(String userName) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysMenuMapper mapper = session.getMapper(SysMenuMapper.class);
            SelectStatementProvider selectStatement = null;
            if (userName == null || "".equals(userName) || SysConstants.ADMIN.equalsIgnoreCase(userName)) {
                return mapper.getAll();
            }
            return mapper.getByUserName(userName);
        }
    }

    private void findChildren(List<SysMenu> sysMenus, List<SysMenu> menus, int menuType) {
        for (SysMenu sysMenu : sysMenus) {
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus) {
                if (menuType == 1 && menu.getType() == 2) {
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                if (sysMenu.getId() != null && sysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(sysMenu.getName());
                    menu.setLevel(sysMenu.getLevel() + 1);
                    if (!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            sysMenu.setChildren(children);
            children.sort(Comparator.comparing(SysMenu::getOrderNum));
            findChildren(children, menus, menuType);
        }
    }

    private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu) {
        return sysMenus.stream().anyMatch(menu -> menu.getId().equals(sysMenu.getId()));
    }
}
