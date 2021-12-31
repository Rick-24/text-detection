package dlut.edu.text.integration.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class SysUser {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String nickName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String avatar;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String salt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String mobile;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte status;

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
    public String getNickName() {
        return nickName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAvatar() {
        return avatar;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPassword() {
        return password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSalt() {
        return salt;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEmail() {
        return email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMobile() {
        return mobile;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Byte status) {
        this.status = status;
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