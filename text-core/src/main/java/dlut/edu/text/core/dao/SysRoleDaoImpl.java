package dlut.edu.text.core.dao;

import dlut.edu.text.common.consts.SysConstants;
import dlut.edu.text.integration.mbg.mapper.*;
import dlut.edu.text.integration.mbg.model.SysMenu;
import dlut.edu.text.integration.mbg.model.SysRole;
import dlut.edu.text.integration.mbg.model.SysRoleMenu;
import dlut.edu.text.service.dao.SysMenuDao;
import dlut.edu.text.service.dao.SysRoleDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static dlut.edu.text.integration.mbg.mapper.SysRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/2 14:09
 */
@Repository
public class SysRoleDaoImpl implements SysRoleDao {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<SysRole> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            Optional<SysRole> sysRole = mapper.selectByPrimaryKey(roleId);
            SysMenuMapper sysMenuMapper = session.getMapper(SysMenuMapper.class);

            if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.get().getName())) {
                return sysMenuMapper.getAll();
            }
            return sysMenuMapper.getRoleMenus(roleId);
        }

    }
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            if(records == null || records.isEmpty()) {
                return 1;
            }
            Long roleId = records.get(0).getRoleId();
            SysRoleMenuMapper mapper = session.getMapper(SysRoleMenuMapper.class);
            mapper.deleteByRoleId(roleId);
            records.forEach(mapper::insertSelective);
        }
        return 1;
    }

    @Override
    public List<SysRole> findByName(String name) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            return mapper.getByName(name);
        }
    }
}