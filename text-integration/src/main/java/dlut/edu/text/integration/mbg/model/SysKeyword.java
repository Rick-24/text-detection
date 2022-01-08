package dlut.edu.text.integration.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import javax.annotation.Generated;

public class SysKeyword {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String value;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long typeid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String description;
    
    private String type;
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
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
    public String getValue() {
        return value;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTypeid() {
        return typeid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDescription() {
        return description;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}