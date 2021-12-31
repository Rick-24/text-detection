package dlut.edu.text.core.dao;

import dlut.edu.text.integration.mbg.mapper.SysMenuMapper;
import dlut.edu.text.integration.mbg.mapper.SysRuleMapper;
import dlut.edu.text.integration.mbg.mapper.SysUserMapper;
import dlut.edu.text.integration.mbg.model.SysUser;
import dlut.edu.text.service.dao.SysUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<SysUser> getAllUsers() {
        return null;
    }

    @Override
    public List<String> getPermissions(String username) {
        return null;
    }

    @Override
    public Optional<SysUser> getUserByName(String username) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);

            SelectStatementProvider provider =
                    select(id,name,nickName,avatar,password,salt,email,mobile,status,createBy,createTime,lastUpdateBy,lastUpdateTime,delFlag)
                            .from(sysUser)
                            .where(name, isEqualTo(username))
                            .build().render(RenderingStrategies.MYBATIS3);

            return mapper.selectOne(provider);
        }
    }
}
