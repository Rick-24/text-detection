package dlut.edu.textdetection.init;

import dlut.edu.textdetection.mbg.mapper.SysRegionMapper;
import dlut.edu.textdetection.mbg.mapper.SysRuleMapper;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/14 16:06
 */
@Component
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        Environment environment = new Environment("test", new JdbcTransactionFactory(), dataSource);
        Configuration config = new Configuration(environment);
        config.addMapper(SysRegionMapper.class);
        config.addMapper(SysRuleMapper.class);
        return new SqlSessionFactoryBuilder().build(config);
    }
}
