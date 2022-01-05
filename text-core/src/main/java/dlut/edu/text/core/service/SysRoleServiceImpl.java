package dlut.edu.text.core.service;

import dlut.edu.text.common.consts.SysConstants;
import dlut.edu.text.integration.mbg.mapper.SysMenuMapper;
import dlut.edu.text.integration.mbg.mapper.SysRoleMapper;
import dlut.edu.text.integration.mbg.mapper.SysRoleMenuMapper;
import dlut.edu.text.integration.mbg.model.SysMenu;
import dlut.edu.text.integration.mbg.model.SysRole;
import dlut.edu.text.integration.mbg.model.SysRoleMenu;
import dlut.edu.text.service.page.MybatisPageHelper;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.page.PageResult;
import dlut.edu.text.service.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/5 10:35
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    
    @Autowired
    private SysRoleMapper sysRoleMapper;
    
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    
    @Autowired
    private SysMenuMapper sysMenuMapper;
    
    @Override
    public int save(SysRole record) {
        if(record.getId() == null || record.getId()==0) {
            return sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }
    
    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }
    
    @Override
    public int delete(List<SysRole> records) {
        records.forEach(this::delete);
        return 1;
    }
    
    @Override
    public Optional<SysRole> findById(Long id) {
        return Optional.ofNullable(sysRoleMapper.selectByPrimaryKey(id));
    }
    
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("name");
        if(label != null) {
            return MybatisPageHelper.findPage(pageRequest,sysRoleMapper,"findPageByName",label);
        }
        return MybatisPageHelper.findPage(pageRequest,sysRoleMapper);
    }
    
    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.getAll();
    }
    
    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())){
            return sysMenuMapper.getAll();
        }
        return sysMenuMapper.getRoleMenus(roleId);
    }
    
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if(records == null || records.isEmpty()) {
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        records.forEach(sysRoleMenuMapper::insertSelective);
        return 1;
    }
    
    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.getByName(name);
    }
}
