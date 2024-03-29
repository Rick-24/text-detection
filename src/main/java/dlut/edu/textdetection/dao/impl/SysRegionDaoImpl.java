package dlut.edu.textdetection.dao.impl;

import dlut.edu.textdetection.dao.SysRegionDao;
import dlut.edu.textdetection.mbg.mapper.SysRegionMapper;
import dlut.edu.textdetection.mbg.model.SysRegion;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static dlut.edu.textdetection.mbg.mapper.SysRegionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 17:58
 */
@Repository
public class SysRegionDaoImpl implements SysRegionDao {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<SysRegion> getAllProvinces() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRegionMapper mapper = session.getMapper(SysRegionMapper.class);

            SelectStatementProvider provider =
                    select(code,id,levelId,parentId,name)
                            .from(sysRegion)
                            .where(levelId,isEqualTo("1"))
                            .build().render(RenderingStrategies.MYBATIS3);

            return mapper.selectMany(provider);
        }
    }

    @Override
    public List<SysRegion> getSubRegionById(Long areaCode) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRegionMapper mapper = session.getMapper(SysRegionMapper.class);

            SelectStatementProvider provider =
                    select(code,id,levelId,parentId,name)
                            .from(sysRegion)
                            .where(parentId,isEqualTo(areaCode))
                            .build().render(RenderingStrategies.MYBATIS3);

            return mapper.selectMany(provider);
        }
    }

}
