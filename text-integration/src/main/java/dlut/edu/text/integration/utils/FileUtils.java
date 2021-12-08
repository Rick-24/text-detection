package dlut.edu.text.integration.utils;


import dlut.edu.text.common.consts.ApplicationValues;
import dlut.edu.text.common.consts.AreaEnum;
import dlut.edu.text.integration.mbg.model.SysRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 14:28
 */
@Component
public class FileUtils {

    private static ApplicationValues applicationValues;

    private FileUtils() {
    }

    @Autowired
    public void setValues(ApplicationValues applicationValues) {
        FileUtils.applicationValues = applicationValues;
        System.out.println("注入成功");
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
        return rootPath + result +".docx";
    }

}
