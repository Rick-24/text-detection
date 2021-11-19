package dlut.edu.textdetection.dao.impl;

import dlut.edu.textdetection.dao.SysRuleDao;
import dlut.edu.textdetection.mbg.mapper.SysRuleMapper;
import dlut.edu.textdetection.mbg.model.SysRule;
import dlut.edu.textdetection.model.enums.AreaEnum;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static dlut.edu.textdetection.mbg.mapper.SysRuleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/14 16:44
 */
@Repository
public class SysRuleDaoImpl implements SysRuleDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<SysRule> getSysRuleByAreaCode(Long areaCode) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRuleMapper mapper = session.getMapper(SysRuleMapper.class);

            SelectStatementProvider provider =
                    select(id, filename, code)
                            .from(sysRule)
                            .where(code, isEqualTo(areaCode))
                            .build().render(RenderingStrategies.MYBATIS3);

            return mapper.selectMany(provider);
        }
    }

    @Override
    public Map<AreaEnum, List<SysRule>> getSysRuleAndAboveByAreaCode(Long areaCode) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRuleMapper mapper = session.getMapper(SysRuleMapper.class);

            SelectStatementProvider provider =
                    select(id, code, filename)
                            .from(sysRule)
                            .where(code, isEqualTo(areaCode))
                            .or(code, isEqualTo(areaCode / 100 * 100))
                            .or(code, isEqualTo(areaCode / 10000 * 10000))
                            .build().render(RenderingStrategies.MYBATIS3);

            List<SysRule> sysRules = mapper.selectMany(provider);
            return sysRules.stream().collect(
                    Collectors.groupingBy(sysRule ->
                            AreaEnum.parseAreaCode(sysRule.getCode())));
        }
    }

    @Override
    public void insertMutipleSysRules(List<SysRule> sysRuleList) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRuleMapper mapper = session.getMapper(SysRuleMapper.class);

            MultiRowInsertStatementProvider<SysRule> insertProvider = insertMultiple(sysRuleList)
                    .into(sysRule)
                    .map(code).toProperty("filename")
                    .map(filename).toProperty("fileName")
                    .map(id).toProperty("id")
                    .build().render(RenderingStrategies.MYBATIS3);
            mapper.insertMultiple(insertProvider);
        }
    }

    @Override
    public void insertSysRule(String fileName, Long areaCode) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRuleMapper mapper = session.getMapper(SysRuleMapper.class);
            // SysRule r = SysRule.builder()
            //         .code(areaCode)
            //         .filename(fileName)
            //         .build();
            // InsertStatementProvider<SysRule> insertProvider = insert(r)
            //         .into(sysRule)
            //         .map(code).toProperty("filename")
            //         .map(filename).toProperty("fileName")
            //         .map(id).toProperty("id")
            //         .build().render(RenderingStrategies.MYBATIS3);
            // mapper.insert(insertProvider);
        }
    }
}
