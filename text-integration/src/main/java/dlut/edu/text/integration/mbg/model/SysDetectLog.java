package dlut.edu.text.integration.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class SysDetectLog {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime date;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String resultpath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String filepath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String username;

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
    public LocalDateTime getDate() {
        return date;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getResultpath() {
        return resultpath;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setResultpath(String resultpath) {
        this.resultpath = resultpath == null ? null : resultpath.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFilepath() {
        return filepath;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUsername() {
        return username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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