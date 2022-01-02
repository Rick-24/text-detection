package dlut.edu.text.core.dao;

import dlut.edu.text.integration.mbg.mapper.SysMenuMapper;
import dlut.edu.text.integration.mbg.mapper.SysRuleMapper;
import dlut.edu.text.integration.mbg.mapper.SysUserMapper;
import dlut.edu.text.integration.mbg.mapper.SysUserRoleMapper;
import dlut.edu.text.integration.mbg.model.SysMenu;
import dlut.edu.text.integration.mbg.model.SysUser;
import dlut.edu.text.integration.mbg.model.SysUserRole;
import dlut.edu.text.service.dao.SysMenuDao;
import dlut.edu.text.service.dao.SysRoleDao;
import dlut.edu.text.service.dao.SysUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static dlut.edu.text.integration.mbg.mapper.SysUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/12/31 15:51
 */
@Repository
public class SysUserDaoImpl implements SysUserDao {

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
        try(SqlSession session = sqlSessionFactory.openSession()) {
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
}
