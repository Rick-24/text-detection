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

    public static InvokeResult buildFailedInvokeResult(Throwable e){
        InvokeResult<Object> invokeResult = new InvokeResult<>();

        invokeResult.setStatus(FAIL);
        invokeResult.setErrorMessage(e.getMessage());
        if(e.getMessage() == null){
            invokeResult.setErrorMessage(GlobalErrorCode.SYSTEM_ERROR.getErrorMessage());
            invokeResult.setErrorCode(GlobalErrorCode.SYSTEM_ERROR.getErrorCode());
        }
        return invokeResult;
    }
}
