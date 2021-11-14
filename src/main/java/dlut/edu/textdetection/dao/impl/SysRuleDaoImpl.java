package dlut.edu.textdetection.dao.impl;

import dlut.edu.textdetection.dao.SysRuleDao;
import dlut.edu.textdetection.mbg.mapper.SysRuleDynamicSqlSupport;
import dlut.edu.textdetection.mbg.mapper.SysRuleMapper;
import dlut.edu.textdetection.mbg.model.SysRule;
import dlut.edu.textdetection.model.enums.AreaEnum;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static dlut.edu.textdetection.mbg.mapper.SysRuleDynamicSqlSupport.id;
import static dlut.edu.textdetection.mbg.mapper.SysRuleDynamicSqlSupport.code;
import static dlut.edu.textdetection.mbg.mapper.SysRuleDynamicSqlSupport.filename;
import static dlut.edu.textdetection.mbg.mapper.SysRuleDynamicSqlSupport.sysRule;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/14 16:44
 */
public class SysRuleDaoImpl implements SysRuleDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<SysRule> getSysRuleByAreaCode(String areaCode) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRuleMapper mapper = session.getMapper(SysRuleMapper.class);

            SelectStatementProvider provider =
                    select(id,filename,code)
                    .from(sysRule)
                    .where(code,isEqualTo("4"))
                    .build().render(RenderingStrategies.MYBATIS3);

           return mapper.selectMany(provider);

        }
    }

    @Override
    public Map<AreaEnum, List<SysRule>> getSysRuleAndAboveByAreaCode(String areaCode) {
        return null;
    }
}
