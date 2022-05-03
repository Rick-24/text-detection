package dlut.edu.text.integration.mbg.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SysDetectLogDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SysDetectLog sysDetectLog = new SysDetectLog();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = sysDetectLog.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> date = sysDetectLog.date;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> resultpath = sysDetectLog.resultpath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> filepath = sysDetectLog.filepath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> username = sysDetectLog.username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> filename = sysDetectLog.filename;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class SysDetectLog extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> date = column("date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> resultpath = column("resultPath", JDBCType.VARCHAR);

        public final SqlColumn<String> filepath = column("filePath", JDBCType.VARCHAR);

        public final SqlColumn<String> username = column("userName", JDBCType.VARCHAR);

        public final SqlColumn<String> filename = column("fileName", JDBCType.VARCHAR);

        public SysDetectLog() {
            super("sys_detect_log");
        }
    }
}