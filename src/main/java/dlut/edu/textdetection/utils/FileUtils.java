package dlut.edu.textdetection.utils;

import dlut.edu.textdetection.init.ApplicationValues;
import dlut.edu.textdetection.mbg.model.SysRule;
import dlut.edu.textdetection.model.enums.AreaEnum;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 14:28
 */
public class FileUtils {
    @Autowired
    private static ApplicationValues applicationValues;

    private FileUtils() {
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

    public static String parseFilePath(SysRule sysRule) {
        String rootPath = applicationValues.getRootPath();
        Long code = sysRule.getCode();
        String result = sysRule.getFilename();
        AreaEnum areaEnum = AreaEnum.parseAreaCode(code);
        switch (areaEnum) {
            case DISTRICT:
                result = code % 100 + "/" + result;
            case CITY:
                result = code / 100 % 100 + "/" + result;
            case PROVINCE:
                result = code / 10000 + "/" + result;
        }
        return rootPath + result;
    }

}
