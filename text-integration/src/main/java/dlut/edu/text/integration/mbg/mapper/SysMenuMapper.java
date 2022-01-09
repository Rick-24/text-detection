package dlut.edu.text.integration.mbg.mapper;

import dlut.edu.text.integration.mbg.model.SysMenu;
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
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

import static dlut.edu.text.integration.mbg.mapper.SysMenuDynamicSqlSupport.*;
import static dlut.edu.text.integration.mbg.mapper.SysRoleMenuDynamicSqlSupport.sysRoleMenu;
import static dlut.edu.text.integration.mbg.mapper.SysUserDynamicSqlSupport.sysUser;
import static dlut.edu.text.integration.mbg.mapper.SysUserRoleDynamicSqlSupport.sysUserRole;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SysMenuMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, parentId, url, perms, type, icon, orderNum, createBy, createTime, lastUpdateBy, lastUpdateTime, delFlag);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "record.id", before = false, resultType = Long.class)
    int insert(InsertStatementProvider<SysMenu> insertStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("SysMenuResult")
    SysMenu selectOne(SelectStatementProvider selectStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "SysMenuResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_id", property = "parentId", jdbcType = JdbcType.BIGINT),
            @Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "perms", property = "perms", jdbcType = JdbcType.VARCHAR),
            @Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_num", property = "orderNum", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_by", property = "createBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "last_update_by", property = "lastUpdateBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "last_update_time", property = "lastUpdateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "del_flag", property = "delFlag", jdbcType = JdbcType.TINYINT)
    })
    List<SysMenu> selectMany(SelectStatementProvider selectStatement);
    
    default List<SysMenu> getAll(){
        SelectStatementProvider selectStatement = SqlBuilder.select(sysMenu.allColumns())
                .from(sysUser)
                .join(sysUserRole).on(sysUserRole.userId, equalTo(sysUser.id))
                .join(sysRoleMenu).on(sysRoleMenu.roleId, equalTo(sysUserRole.roleId))
                .join(sysMenu).on(sysMenu.id, equalTo(sysRoleMenu.menuId))
                .build().render(RenderingStrategies.MYBATIS3);
        return selectMany(selectStatement);
    }
    
    default List<SysMenu> getRoleMenus(Long roleId) {
        SelectStatementProvider selectStatement =
                SqlBuilder.select(selectList)
                        .from(sysMenu)
                        .join(sysRoleMenu).on(sysRoleMenu.menuId, equalTo(sysMenu.id))
                        .where(sysRoleMenu.roleId, isEqualTo(roleId))
                        .build().render(RenderingStrategies.MYBATIS3);
        return selectMany(selectStatement);
    }
    
    default List<SysMenu> getByUserName(String userName) {
        SelectStatementProvider selectStatement = SqlBuilder.select(sysMenu.allColumns())
                .from(sysUser)
                .join(sysUserRole).on(sysUserRole.userId, equalTo(sysUser.id))
                .join(sysRoleMenu).on(sysRoleMenu.roleId, equalTo(sysUserRole.roleId))
                .join(sysMenu).on(sysMenu.id, equalTo(sysRoleMenu.menuId))
                .where(sysUser.name, isEqualTo(userName))
                .build().render(RenderingStrategies.MYBATIS3);
        return selectMany(selectStatement);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysMenu, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysMenu, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SysMenu record) {
        return MyBatis3Utils.insert(this::insert, record, sysMenu, c ->
                c.map(name).toProperty("name")
                        .map(parentId).toProperty("parentId")
                        .map(url).toProperty("url")
                        .map(perms).toProperty("perms")
                        .map(type).toProperty("type")
                        .map(icon).toProperty("icon")
                        .map(orderNum).toProperty("orderNum")
                        .map(createBy).toProperty("createBy")
                        .map(createTime).toProperty("createTime")
                        .map(lastUpdateBy).toProperty("lastUpdateBy")
                        .map(lastUpdateTime).toProperty("lastUpdateTime")
                        .map(delFlag).toProperty("delFlag")
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SysMenu record) {
        return MyBatis3Utils.insert(this::insert, record, sysMenu, c ->
                c.map(name).toPropertyWhenPresent("name", record::getName)
                        .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
                        .map(url).toPropertyWhenPresent("url", record::getUrl)
                        .map(perms).toPropertyWhenPresent("perms", record::getPerms)
                        .map(type).toPropertyWhenPresent("type", record::getType)
                        .map(icon).toPropertyWhenPresent("icon", record::getIcon)
                        .map(orderNum).toPropertyWhenPresent("orderNum", record::getOrderNum)
                        .map(createBy).toPropertyWhenPresent("createBy", record::getCreateBy)
                        .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                        .map(lastUpdateBy).toPropertyWhenPresent("lastUpdateBy", record::getLastUpdateBy)
                        .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
                        .map(delFlag).toPropertyWhenPresent("delFlag", record::getDelFlag)
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default SysMenu selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysMenu, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysMenu> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysMenu, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysMenu> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysMenu, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default SysMenu selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysMenu, completer);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SysMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(record::getName)
                .set(parentId).equalTo(record::getParentId)
                .set(url).equalTo(record::getUrl)
                .set(perms).equalTo(record::getPerms)
                .set(type).equalTo(record::getType)
                .set(icon).equalTo(record::getIcon)
                .set(orderNum).equalTo(record::getOrderNum)
                .set(createBy).equalTo(record::getCreateBy)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdateBy).equalTo(record::getLastUpdateBy)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
                .set(delFlag).equalTo(record::getDelFlag);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(record::getName)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(perms).equalToWhenPresent(record::getPerms)
                .set(type).equalToWhenPresent(record::getType)
                .set(icon).equalToWhenPresent(record::getIcon)
                .set(orderNum).equalToWhenPresent(record::getOrderNum)
                .set(createBy).equalToWhenPresent(record::getCreateBy)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdateBy).equalToWhenPresent(record::getLastUpdateBy)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
                .set(delFlag).equalToWhenPresent(record::getDelFlag);
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SysMenu record) {
        return update(c ->
                c.set(name).equalTo(record::getName)
                        .set(parentId).equalTo(record::getParentId)
                        .set(url).equalTo(record::getUrl)
                        .set(perms).equalTo(record::getPerms)
                        .set(type).equalTo(record::getType)
                        .set(icon).equalTo(record::getIcon)
                        .set(orderNum).equalTo(record::getOrderNum)
                        .set(createBy).equalTo(record::getCreateBy)
                        .set(createTime).equalTo(record::getCreateTime)
                        .set(lastUpdateBy).equalTo(record::getLastUpdateBy)
                        .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
                        .set(delFlag).equalTo(record::getDelFlag)
                        .where(id, isEqualTo(record::getId))
        );
    }
    
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SysMenu record) {
        return update(c ->
                c.set(name).equalToWhenPresent(record::getName)
                        .set(parentId).equalToWhenPresent(record::getParentId)
                        .set(url).equalToWhenPresent(record::getUrl)
                        .set(perms).equalToWhenPresent(record::getPerms)
                        .set(type).equalToWhenPresent(record::getType)
                        .set(icon).equalToWhenPresent(record::getIcon)
                        .set(orderNum).equalToWhenPresent(record::getOrderNum)
                        .set(createBy).equalToWhenPresent(record::getCreateBy)
                        .set(createTime).equalToWhenPresent(record::getCreateTime)
                        .set(lastUpdateBy).equalToWhenPresent(record::getLastUpdateBy)
                        .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
                        .set(delFlag).equalToWhenPresent(record::getDelFlag)
                        .where(id, isEqualTo(record::getId))
        );
    }
    
    default List<SysMenu> findPage(){
        SelectStatementProvider provider = SqlBuilder.select(sysMenu.allColumns())
                .from(sysMenu)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return selectMany(provider);
    }
}