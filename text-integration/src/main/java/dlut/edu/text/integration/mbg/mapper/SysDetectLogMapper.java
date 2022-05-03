package dlut.edu.text.integration.mbg.mapper;

import dlut.edu.text.integration.mbg.model.SysDetectLog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import javax.annotation.Generated;
import java.util.List;

import static dlut.edu.text.integration.mbg.mapper.SysDetectLogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SysDetectLogMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, date, resultpath, filepath, username, filename);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<SysDetectLog> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysDetectLogResult")
    SysDetectLog selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysDetectLogResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="resultPath", property="resultpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="filePath", property="filepath", jdbcType=JdbcType.VARCHAR),
        @Result(column="userName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileName", property="filename", jdbcType=JdbcType.VARCHAR)
    })
    List<SysDetectLog> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysDetectLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysDetectLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SysDetectLog record) {
        return MyBatis3Utils.insert(this::insert, record, sysDetectLog, c ->
            c.map(date).toProperty("date")
            .map(resultpath).toProperty("resultpath")
            .map(filepath).toProperty("filepath")
            .map(username).toProperty("username")
            .map(filename).toProperty("filename")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SysDetectLog record) {
        return MyBatis3Utils.insert(this::insert, record, sysDetectLog, c ->
            c.map(date).toPropertyWhenPresent("date", record::getDate)
            .map(resultpath).toPropertyWhenPresent("resultpath", record::getResultpath)
            .map(filepath).toPropertyWhenPresent("filepath", record::getFilepath)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(filename).toPropertyWhenPresent("filename", record::getFilename)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default SysDetectLog selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysDetectLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysDetectLog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysDetectLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysDetectLog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysDetectLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default SysDetectLog selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysDetectLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SysDetectLog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(date).equalTo(record::getDate)
                .set(resultpath).equalTo(record::getResultpath)
                .set(filepath).equalTo(record::getFilepath)
                .set(username).equalTo(record::getUsername)
                .set(filename).equalTo(record::getFilename);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysDetectLog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(date).equalToWhenPresent(record::getDate)
                .set(resultpath).equalToWhenPresent(record::getResultpath)
                .set(filepath).equalToWhenPresent(record::getFilepath)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(filename).equalToWhenPresent(record::getFilename);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SysDetectLog record) {
        return update(c ->
            c.set(date).equalTo(record::getDate)
            .set(resultpath).equalTo(record::getResultpath)
            .set(filepath).equalTo(record::getFilepath)
            .set(username).equalTo(record::getUsername)
            .set(filename).equalTo(record::getFilename)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SysDetectLog record) {
        return update(c ->
            c.set(date).equalToWhenPresent(record::getDate)
            .set(resultpath).equalToWhenPresent(record::getResultpath)
            .set(filepath).equalToWhenPresent(record::getFilepath)
            .set(username).equalToWhenPresent(record::getUsername)
            .set(filename).equalToWhenPresent(record::getFilename)
            .where(id, isEqualTo(record::getId))
        );
    }
    default List<SysDetectLog> findPage(){
        SelectStatementProvider p = SqlBuilder.select(sysDetectLog.allColumns())
                .from(sysDetectLog)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return selectMany(p);
    }
}