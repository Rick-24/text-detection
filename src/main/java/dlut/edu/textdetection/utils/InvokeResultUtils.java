package dlut.edu.textdetection.utils;

import dlut.edu.textdetection.model.enums.GlobalErrorCode;
import dlut.edu.textdetection.model.result.InvokeResult;

import static dlut.edu.textdetection.model.result.InvokeResult.FAIL;
import static dlut.edu.textdetection.model.result.InvokeResult.SUCCESS;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/23 13:14
 */
public class InvokeResultUtils {
    public static <T> InvokeResult<T> buildSuccessInvokeResult(T value){
        InvokeResult<T> invokeResult = new InvokeResult<>();

        invokeResult.setStatus(SUCCESS);
        invokeResult.setValue(value);

        return invokeResult;
    }

    public static InvokeResult buildFailedInvokeResult(GlobalErrorCode errorCode){
        InvokeResult<Object> invokeResult = new InvokeResult<>();

        invokeResult.setStatus(FAIL);
        invokeResult.setErrorMessage(errorCode.getErrorMessage());
        invokeResult.setErrorCode(errorCode.getErrorCode());
        return invokeResult;
    }
}
