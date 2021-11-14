package dlut.edu.textdetection.mbg.model;

import lombok.ToString;

import javax.annotation.Generated;
@ToString
public class SysRegion {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long parentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String levelId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getCode() {
        return code;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCode(Long code) {
        this.code = code;
    }

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
    public Long getParentId() {
        return parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLevelId() {
        return levelId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
    }
}