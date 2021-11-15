package dlut.edu.textdetection.model.enums;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/14 16:41
 */
public enum AreaEnum {
    /**
     * 省
     */
    PROVINCE,
    /**
     * 市
     */
    CITY,
    /**
     * 区
     */
    DISTRICT;

    public static AreaEnum parseAreaCode(Long code) {
        if (code % 10000 == 0) {
            return AreaEnum.PROVINCE;
        } else if (code % 100 == 0) {
            return AreaEnum.CITY;
        } else {
            return AreaEnum.DISTRICT;
        }
    }
}
