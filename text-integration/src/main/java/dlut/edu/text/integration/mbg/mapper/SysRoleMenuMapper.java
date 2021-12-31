package dlut.edu.text.integration.mbg.mapper;

import static dlut.edu.text.integration.mbg.mapper.SysRoleMenuDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import dlut.edu.text.integration.mbg.model.SysRoleMenu;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface SysRoleMenuMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, roleId, menuId, createBy, createTime, lastUpdateBy, lastUpdateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<SysRoleMenu> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysRoleMenuResult")
    Optional<SysRoleMenu> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysRoleMenuResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update_by", property="lastUpdateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysRoleMenu> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SysRoleMenu record) {
        return MyBatis3Utils.insert(this::insert, record, sysRoleMenu, c ->
            c.map(roleId).toProperty("roleId")
            .map(menuId).toProperty("menuId")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(lastUpdateBy).toProperty("lastUpdateBy")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SysRoleMenu record) {
        return MyBatis3Utils.insert(this::insert, record, sysRoleMenu, c ->
            c.map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(menuId).toPropertyWhenPresent("menuId", record::getMenuId)
            .map(createBy).toPropertyWhenPresent("createBy", record::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(lastUpdateBy).toPropertyWhenPresent("lastUpdateBy", record::getLastUpdateBy)
            .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysRoleMenu> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysRoleMenu> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysRoleMenu> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysRoleMenu> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SysRoleMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleId).equalTo(record::getRoleId)
                .set(menuId).equalTo(record::getMenuId)
                .set(createBy).equalTo(record::getCreateBy)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdateBy).equalTo(record::getLastUpdateBy)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysRoleMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleId).equalToWhenPresent(record::getRoleId)
                .set(menuId).equalToWhenPresent(record::getMenuId)
                .set(createBy).equalToWhenPresent(record::getCreateBy)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdateBy).equalToWhenPresent(record::getLastUpdateBy)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SysRoleMenu record) {
        return update(c ->
            c.set(roleId).equalTo(record::getRoleId)
            .set(menuId).equalTo(record::getMenuId)
            .set(createBy).equalTo(record::getCreateBy)
            .set(createTime).equalTo(record::getCreateTime)
            .set(lastUpdateBy).equalTo(record::getLastUpdateBy)
            .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SysRoleMenu record) {
        return update(c ->
            c.set(roleId).equalToWhenPresent(record::getRoleId)
            .set(menuId).equalToWhenPresent(record::getMenuId)
            .set(createBy).equalToWhenPresent(record::getCreateBy)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(lastUpdateBy).equalToWhenPresent(record::getLastUpdateBy)
            .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}