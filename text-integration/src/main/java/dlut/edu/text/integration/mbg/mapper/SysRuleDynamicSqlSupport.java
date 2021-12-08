package dlut.edu.text.integration.mbg.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SysRuleDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SysRule sysRule = new SysRule();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = sysRule.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> code = sysRule.code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> filename = sysRule.filename;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class SysRule extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> code = column("code", JDBCType.BIGINT);

        public final SqlColumn<String> filename = column("fileName", JDBCType.VARCHAR);

        public SysRule() {
            super("sys_rule");
        }
    }
}