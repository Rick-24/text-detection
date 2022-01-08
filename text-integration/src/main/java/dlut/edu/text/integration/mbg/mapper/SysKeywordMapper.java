package dlut.edu.text.integration.mbg.mapper;

import dlut.edu.text.integration.mbg.model.SysKeyword;
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
import java.util.Optional;

import static dlut.edu.text.integration.mbg.mapper.SysKeytypeDynamicSqlSupport.sysKeytype;
import static dlut.edu.text.integration.mbg.mapper.SysKeywordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SysKeywordMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, value, typeid, description);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "record.id", before = false, resultType = Long.class)
    int insert(InsertStatementProvider<SysKeyword> insertStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("SysKeywordResult")
    SysKeyword selectOne(SelectStatementProvider selectStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "SysKeywordResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR),
            @Result(column = "typeId", property = "typeid", jdbcType = JdbcType.BIGINT),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "type",property = "type", jdbcType = JdbcType.VARCHAR)
    })
    List<SysKeyword> selectMany(SelectStatementProvider selectStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysKeyword, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysKeyword, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SysKeyword record) {
        return MyBatis3Utils.insert(this::insert, record, sysKeyword, c ->
                c.map(value).toProperty("value")
                        .map(typeid).toProperty("typeid")
                        .map(description).toProperty("description")
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SysKeyword record) {
        return MyBatis3Utils.insert(this::insert, record, sysKeyword, c ->
                c.map(value).toPropertyWhenPresent("value", record::getValue)
                        .map(typeid).toPropertyWhenPresent("typeid", record::getTypeid)
                        .map(description).toPropertyWhenPresent("description", record::getDescription)
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default SysKeyword selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysKeyword, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysKeyword> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysKeyword, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysKeyword> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysKeyword, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default SysKeyword selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysKeyword, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SysKeyword record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(value).equalTo(record::getValue)
                .set(typeid).equalTo(record::getTypeid)
                .set(description).equalTo(record::getDescription);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysKeyword record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(value).equalToWhenPresent(record::getValue)
                .set(typeid).equalToWhenPresent(record::getTypeid)
                .set(description).equalToWhenPresent(record::getDescription);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SysKeyword record) {
        return update(c ->
                c.set(value).equalTo(record::getValue)
                        .set(typeid).equalTo(record::getTypeid)
                        .set(description).equalTo(record::getDescription)
                        .where(id, isEqualTo(record::getId))
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SysKeyword record) {
        return update(c ->
                c.set(value).equalToWhenPresent(record::getValue)
                        .set(typeid).equalToWhenPresent(record::getTypeid)
                        .set(description).equalToWhenPresent(record::getDescription)
                        .where(id, isEqualTo(record::getId))
        );
    }
    
    default List<SysKeyword> getKeysByTypeId(Long typeId_) {
        SelectStatementProvider render = SqlBuilder.select(sysKeyword.allColumns())
                .from(sysKeyword)
                .where(typeid, isEqualTo(typeId_))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return selectMany(render);
    }
    
    default int deleteByTypeId(Long typeId_) {
        return delete(c ->
                c.where(typeid, isEqualTo(typeId_)));
    }
    
    default SysKeyword getByValue(String value_) {
        SelectStatementProvider render = SqlBuilder.select(sysKeyword.allColumns())
                .from(sysKeyword)
                .where(value, isEqualTo(value_))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return selectOne(render);
    }
    default List<SysKeyword> getAll(){
        SelectStatementProvider render = SqlBuilder.select(sysKeyword.allColumns())
                .from(sysKeyword)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return selectMany(render);
    }
    default List<SysKeyword> findPage() {
        SelectStatementProvider render = SqlBuilder.select(sysKeyword.allColumns(), sysKeytype.value.as("type"))
                .from(sysKeyword)
                .join(sysKeytype)
                .on(typeid,equalTo(sysKeytype.id))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return selectMany(render);
    }
    
}