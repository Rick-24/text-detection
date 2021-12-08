package dlut.edu.text.config;

import dlut.edu.text.integration.mbg.mapper.SysRegionMapper;
import dlut.edu.text.integration.mbg.mapper.SysRuleMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

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
