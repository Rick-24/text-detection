package dlut.edu.textdetection.mbg.model;

import dlut.edu.textdetection.model.enums.AreaEnum;
import lombok.ToString;

import javax.annotation.Generated;

@ToString
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

    public AreaEnum parseAreaCode() {
        if (this.code % 10000 == 0) {
            return AreaEnum.PROVINCE;
        } else if (this.code % 100 == 0) {
            return AreaEnum.CITY;
        } else {
            return AreaEnum.DISTRICT;
        }
    }
}