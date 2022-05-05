package dlut.edu.text.integration.mbg.mapper;

import dlut.edu.text.integration.mbg.model.SysRule;
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

import static dlut.edu.text.integration.mbg.mapper.SysRuleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SysRuleMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, code, filename, date, filepath);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<SysRule> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysRuleResult")
    SysRule selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysRuleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.BIGINT),
        @Result(column="fileName", property="filename", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="filePath", property="filepath", jdbcType=JdbcType.VARCHAR)
    })
    List<SysRule> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysRule, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysRule, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SysRule record) {
        return MyBatis3Utils.insert(this::insert, record, sysRule, c ->
            c.map(code).toProperty("code")
            .map(filename).toProperty("filename")
            .map(date).toProperty("date")
            .map(filepath).toProperty("filepath")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SysRule record) {
        return MyBatis3Utils.insert(this::insert, record, sysRule, c ->
            c.map(code).toPropertyWhenPresent("code", record::getCode)
            .map(filename).toPropertyWhenPresent("filename", record::getFilename)
            .map(date).toPropertyWhenPresent("date", record::getDate)
            .map(filepath).toPropertyWhenPresent("filepath", record::getFilepath)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default SysRule selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysRule, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysRule> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysRule, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysRule> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysRule, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default SysRule selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }
    default SysRule selectByFileName(String _fileName) {
        return selectOne(c ->
                c.where(filename,isEqualTo(_fileName))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysRule, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SysRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(code).equalTo(record::getCode)
                .set(filename).equalTo(record::getFilename)
                .set(date).equalTo(record::getDate)
                .set(filepath).equalTo(record::getFilepath);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(code).equalToWhenPresent(record::getCode)
                .set(filename).equalToWhenPresent(record::getFilename)
                .set(date).equalToWhenPresent(record::getDate)
                .set(filepath).equalToWhenPresent(record::getFilepath);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SysRule record) {
        return update(c ->
            c.set(code).equalTo(record::getCode)
            .set(filename).equalTo(record::getFilename)
            .set(date).equalTo(record::getDate)
            .set(filepath).equalTo(record::getFilepath)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SysRule record) {
        return update(c ->
            c.set(code).equalToWhenPresent(record::getCode)
            .set(filename).equalToWhenPresent(record::getFilename)
            .set(date).equalToWhenPresent(record::getDate)
            .set(filepath).equalToWhenPresent(record::getFilepath)
            .where(id, isEqualTo(record::getId))
        );
    }
    
    default List<SysRule> findPage(){
        SelectStatementProvider render = SqlBuilder.select(sysRule.allColumns())
                .from(sysRule)
                .build().render(RenderingStrategies.MYBATIS3);
        return selectMany(render);
    }

}