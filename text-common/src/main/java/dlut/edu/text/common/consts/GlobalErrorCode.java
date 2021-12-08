package dlut.edu.text.common.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/23 13:50
 */
@Getter
@AllArgsConstructor
public enum GlobalErrorCode {
    SYSTEM_ERROR("S_0001","系统异常","系统开小差了，请稍后重试");

    private String errorCode;
    private String errorMessage;
    private String displayMessage;
}
