package dlut.edu.text.integration.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import javax.annotation.Generated;

public class SysRule {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String filename;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getCode() {
        return code;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCode(Long code) {
        this.code = code;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFilename() {
        return filename;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }
}