package dlut.edu.text.core.service;

import dlut.edu.text.integration.mbg.mapper.SysRoleMapper;
import dlut.edu.text.integration.mbg.mapper.SysUserMapper;
import dlut.edu.text.integration.mbg.mapper.SysUserRoleMapper;
import dlut.edu.text.integration.mbg.model.SysMenu;
import dlut.edu.text.integration.mbg.model.SysRole;
import dlut.edu.text.integration.mbg.model.SysUser;
import dlut.edu.text.integration.mbg.model.SysUserRole;
import dlut.edu.text.service.dao.SysMenuDao;
import dlut.edu.text.service.dao.SysRoleDao;
import dlut.edu.text.service.page.MybatisPageHelper;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.page.PageResult;
import dlut.edu.text.service.service.SysUserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/12/31 15:51
 */
@Repository
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysUser> getAllUsers() {
        return null;
    }

    @Override
    public Set<String> getPermissions(String userName) {
        List<SysMenu> sysMenus = sysMenuDao.findByUser(userName);
        return sysMenus.stream()
                .map(SysMenu::getPerms)
                .filter(StringUtils::hasText)
                .collect(Collectors.toSet());
    }

    @Override
    public List<SysUserRole> getUserRoles(Long userId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysUserRoleMapper mapper = session.getMapper(SysUserRoleMapper.class);
            return mapper.getUserRoles(userId);
        }
    }

    @Override
    public Optional<SysUser> getUserByName(String username) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);

            return mapper.getByName(username);
        }
    }

    @Override
    public int save(SysUser record) {
        Long id = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            SysUserRoleMapper sysUserRoleMapper = session.getMapper(SysUserRoleMapper.class);
            if (record.getId() == null || record.getId() == 0) {
                // 新增用户
                mapper.insertSelective(record);
                id = record.getId();
            } else {
                // 更新用户
                mapper.updateByPrimaryKeySelective(record);
            }

            // 更新用户信息
            if (id != null && id ==0) {
                return 1;
            }

            if(id !=null) {
                for(SysUserRole sysUserRole: record.getUserRoles()) {
                    sysUserRole.setUserId(id);
                }
            } else {
                sysUserRoleMapper.deleteByPrimaryKey(record.getId());
            }

            for(SysUserRole sysUserRole: record.getUserRoles()) {
                sysUserRoleMapper.insertSelective(sysUserRole);
            }
            return 1;
        }
    }

    @Override
    public int delete(SysUser record) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            return mapper.deleteByPrimaryKey(record.getId());
        }
    }

    @Override
    public int delete(List<SysUser> records) {
        records.forEach(this::delete);
        return 1;
    }

    @Override
    public Optional<SysUser> findById(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            return mapper.selectByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            PageResult pageResult = null;
            Object name = pageRequest.getParam("name");
            Object email = pageRequest.getParam("email");
            if(name !=null) {
                if(email !=null) {
                    pageResult = MybatisPageHelper.findPage(pageRequest,mapper,"findPageByNameAndEmail",name,email);
                }else{
                    pageResult = MybatisPageHelper.findPage(pageRequest,mapper,"findPageByName",name);
                }
            }else {
                pageResult = MybatisPageHelper.findPage(pageRequest,mapper);
            }
            findUserRoles(pageResult);
            return pageResult;
        }

    }

    private void findUserRoles(PageResult pageResult) {
        List<?> content = pageResult.getContent();
        for(Object object:content) {
            SysUser sysUser = (SysUser) object;
            List<SysUserRole> userRoles = getUserRoles(sysUser.getId());
            sysUser.setUserRoles(userRoles);
            sysUser.setRoleNames(getRoleNames(userRoles));
        }
    }


    private String getRoleNames(List<SysUserRole> userRoles) {
        StringBuilder sb = new StringBuilder();
        for(Iterator<SysUserRole> iter = userRoles.iterator(); iter.hasNext();) {
            SysUserRole userRole = iter.next();
            try (SqlSession session = sqlSessionFactory.openSession()) {
                SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
                Optional<SysRole> sysRole = mapper.selectByPrimaryKey(userRole.getRoleId());
                if(!sysRole.isPresent()) {
                    continue ;
                }
                sb.append(sysRole.get().getRemark());
                if(iter.hasNext()) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }
}
