package dlut.edu.text.integration.mbg.mapper;

import static dlut.edu.text.integration.mbg.mapper.SysUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

import dlut.edu.text.integration.mbg.model.SysUser;
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

@Mapper
public interface SysUserMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, nickName, avatar, password, salt, email, mobile, status, createBy, createTime, lastUpdateBy, lastUpdateTime, delFlag);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<SysUser> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysUserResult")
    Optional<SysUser> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysUserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update_by", property="lastUpdateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.TINYINT)
    })
    List<SysUser> selectMany(SelectStatementProvider selectStatement);

    default Optional<SysUser> getByName(String name_){
        SelectStatementProvider provider =
                SqlBuilder.select(id, name, nickName, avatar, password, salt, email, mobile, status, createBy, createTime, lastUpdateBy, lastUpdateTime, delFlag)
                        .from(sysUser)
                        .where(name, isEqualTo(name_))
                        .build().render(RenderingStrategies.MYBATIS3);
        return selectOne(provider);
    }


    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SysUser record) {
        return MyBatis3Utils.insert(this::insert, record, sysUser, c ->
            c.map(name).toProperty("name")
            .map(nickName).toProperty("nickName")
            .map(avatar).toProperty("avatar")
            .map(password).toProperty("password")
            .map(salt).toProperty("salt")
            .map(email).toProperty("email")
            .map(mobile).toProperty("mobile")
            .map(status).toProperty("status")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(lastUpdateBy).toProperty("lastUpdateBy")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
            .map(delFlag).toProperty("delFlag")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SysUser record) {
        return MyBatis3Utils.insert(this::insert, record, sysUser, c ->
            c.map(name).toPropertyWhenPresent("name", record::getName)
            .map(nickName).toPropertyWhenPresent("nickName", record::getNickName)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(salt).toPropertyWhenPresent("salt", record::getSalt)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(mobile).toPropertyWhenPresent("mobile", record::getMobile)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(createBy).toPropertyWhenPresent("createBy", record::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(lastUpdateBy).toPropertyWhenPresent("lastUpdateBy", record::getLastUpdateBy)
            .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
            .map(delFlag).toPropertyWhenPresent("delFlag", record::getDelFlag)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysUser> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SysUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(record::getName)
                .set(nickName).equalTo(record::getNickName)
                .set(avatar).equalTo(record::getAvatar)
                .set(password).equalTo(record::getPassword)
                .set(salt).equalTo(record::getSalt)
                .set(email).equalTo(record::getEmail)
                .set(mobile).equalTo(record::getMobile)
                .set(status).equalTo(record::getStatus)
                .set(createBy).equalTo(record::getCreateBy)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdateBy).equalTo(record::getLastUpdateBy)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
                .set(delFlag).equalTo(record::getDelFlag);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(record::getName)
                .set(nickName).equalToWhenPresent(record::getNickName)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(salt).equalToWhenPresent(record::getSalt)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(mobile).equalToWhenPresent(record::getMobile)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(createBy).equalToWhenPresent(record::getCreateBy)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdateBy).equalToWhenPresent(record::getLastUpdateBy)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
                .set(delFlag).equalToWhenPresent(record::getDelFlag);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SysUser record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(nickName).equalTo(record::getNickName)
            .set(avatar).equalTo(record::getAvatar)
            .set(password).equalTo(record::getPassword)
            .set(salt).equalTo(record::getSalt)
            .set(email).equalTo(record::getEmail)
            .set(mobile).equalTo(record::getMobile)
            .set(status).equalTo(record::getStatus)
            .set(createBy).equalTo(record::getCreateBy)
            .set(createTime).equalTo(record::getCreateTime)
            .set(lastUpdateBy).equalTo(record::getLastUpdateBy)
            .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
            .set(delFlag).equalTo(record::getDelFlag)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SysUser record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(nickName).equalToWhenPresent(record::getNickName)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(salt).equalToWhenPresent(record::getSalt)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(mobile).equalToWhenPresent(record::getMobile)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(createBy).equalToWhenPresent(record::getCreateBy)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(lastUpdateBy).equalToWhenPresent(record::getLastUpdateBy)
            .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
            .set(delFlag).equalToWhenPresent(record::getDelFlag)
            .where(id, isEqualTo(record::getId))
        );
    }
}