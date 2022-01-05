package core.service;

import dlut.edu.text.TextDetectionApplication;
import dlut.edu.text.integration.mbg.mapper.SysUserMapper;
import dlut.edu.text.integration.mbg.model.SysUser;
import dlut.edu.text.service.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static dlut.edu.text.integration.mbg.mapper.SysUserDynamicSqlSupport.*;
import static dlut.edu.text.integration.mbg.mapper.SysUserDynamicSqlSupport.name;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/3 13:28
 */
@SpringBootTest(classes = TextDetectionApplication.class)
public class TestSysUserService {
    @Autowired
    private SysUserService sysUserService;
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Test
    public void test1(){
        Optional<SysUser> admin = sysUserService.getUserByName("admin");
        System.out.println(admin.get());
    }
    
    @Test
    public void test2() {
        SelectStatementProvider provider =
                SqlBuilder.select(id, name, nickName, avatar, password, salt, email, mobile, status, createBy, createTime, lastUpdateBy, lastUpdateTime, delFlag)
                        .from(sysUser)
                        .where(name, isEqualTo("admin"))
                        .build().render(RenderingStrategies.MYBATIS3);
        SysUser admin = sysUserMapper.selectOne(provider);
        System.out.println(admin);
    }
    
    @Test
    public void test3() {
        sysUserMapper.getByName("admin");
    }
}
