package dlut.edu.textdetection.druid;

import com.alibaba.druid.pool.DruidDataSource;
import dlut.edu.textdetection.dao.SysRuleDao;
import dlut.edu.textdetection.mbg.mapper.SysRegionMapper;
import dlut.edu.textdetection.mbg.model.SysRegion;
import dlut.edu.textdetection.mbg.model.SysRule;
import dlut.edu.textdetection.model.enums.AreaEnum;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static dlut.edu.textdetection.mbg.mapper.SysRegionDynamicSqlSupport.id;
import static dlut.edu.textdetection.mbg.mapper.SysRegionDynamicSqlSupport.sysRegion;
import static org.mybatis.dynamic.sql.SqlBuilder.select;


/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/14 11:17
 */
@SpringBootTest
public class ConnectionTest {
    //DI注入数据源
    @Autowired
    DataSource dataSource;
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    SysRuleDao sysRuleDao;


    @Test
    public void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }

    @Test
    public void testConnection(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysRegionMapper mapper = session.getMapper(SysRegionMapper.class);

            SelectStatementProvider provider = select(id)
                    .from(sysRegion)
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            List<SysRegion> sysRegions = mapper.selectMany(provider);

            sysRegions.stream().limit(3).forEach(System.out::println);
        }
    }
    @Test
    public void testGetSysRuleByAreaCode(){
        List<SysRule> sysRuleByAreaCode = sysRuleDao.getSysRuleByAreaCode(210000L);
        sysRuleByAreaCode.stream().forEach(System.out::println);
    }

    @Test
    public void testGetSysRuleAndAboveByAreaCode(){
        Map<AreaEnum, List<SysRule>> sysRuleAndAboveByAreaCode = sysRuleDao.getSysRuleAndAboveByAreaCode(210211L);
        System.out.println(sysRuleAndAboveByAreaCode);
    }
}
