package dlut.edu.text.common.utils;

import org.slf4j.Logger;

import java.text.MessageFormat;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/24 19:31
 */
public class LogUtils {

    public static void info(Logger logger,String pattern, Object[] params){
        String message = MessageFormat.format(pattern, params);
        logger.info(message);
    }

    public static void error(Logger logger,Throwable e){
        logger.error("SystemError",e);
    }

    public static void error(Logger logger,Throwable e,String message){
        logger.error(message,e);
    }
}
