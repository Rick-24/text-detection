package dlut.edu.text.common.utils;


import dlut.edu.text.common.consts.ApplicationValues;
import dlut.edu.text.common.consts.AreaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 14:28
 */
@Component
public class BaseFileUtils {

    private static ApplicationValues applicationValues;

    private BaseFileUtils() {
    }

    @Autowired
    public void setValues(ApplicationValues applicationValues) {
        BaseFileUtils.applicationValues = applicationValues;
    }

    public static String getRuleFileDir(Long areaCode) {
        String result = "";
        AreaEnum areaEnum = AreaEnum.parseAreaCode(areaCode);
        switch (areaEnum) {
            case DISTRICT:
                result = areaCode % 100 + "";
            case CITY:
                result = areaCode / 100 % 100 + "/" + result;
            case PROVINCE:
                result = areaCode / 10000 + "/" + result;
        }
        if (result.isEmpty()) {
            throw new RuntimeException("areaCode 不能正确转换");
        }
        return result;
    }


}
