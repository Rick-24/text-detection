package dlut.edu.text.integration.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class SysRole {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String remark;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String lastUpdateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime lastUpdateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte delFlag;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRemark() {
        return remark;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getDelFlag() {
        return delFlag;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}