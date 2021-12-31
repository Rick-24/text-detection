package dlut.edu.text.integration.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class SysRoleMenu {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long roleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long menuId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String lastUpdateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime lastUpdateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getRoleId() {
        return roleId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getMenuId() {
        return menuId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCreateBy() {
        return createBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}