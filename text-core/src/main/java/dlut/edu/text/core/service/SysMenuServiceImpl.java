package dlut.edu.text.core.service;

import dlut.edu.text.common.consts.SysConstants;
import dlut.edu.text.integration.mbg.mapper.SysMenuMapper;
import dlut.edu.text.integration.mbg.model.SysMenu;
import dlut.edu.text.service.page.MybatisPageHelper;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.page.PageResult;
import dlut.edu.text.service.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/2 12:43
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    
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
        
        if (userName == null || "".equals(userName) || SysConstants.ADMIN.equalsIgnoreCase(userName)) {
            return sysMenuMapper.getAll();
        }
        return sysMenuMapper.getByUserName(userName);
        
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
    
    @Override
    public int save(SysMenu record) {
        if(record.getId() == null || record.getId()==0) {
            return sysMenuMapper.insertSelective(record);
        }
        if(record.getParentId()==null){
            record.setParentId(0L);
        }
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }
    
    @Override
    public int delete(SysMenu record) {
        return sysMenuMapper.deleteByPrimaryKey(record.getId());
    }
    
    @Override
    public int delete(List<SysMenu> records) {
        records.forEach(this::delete);
        return 1;
    }
    
    @Override
    public Optional<SysMenu> findById(Long id) {
        return Optional.ofNullable(sysMenuMapper.selectByPrimaryKey(id));
    }
    
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,sysMenuMapper);
    }
}
