package dlut.edu.textdetection.model.result;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/23 13:10
 */
@Getter
@Setter
public class InvokeResult <T> implements Serializable {

    private static final long serialVersionUID = 6820187525540262236L;

    public static int SUCCESS = 1;
    public static int FAIL = 0;

    private T value;

    private String errorMessage;
    private int status;
    private String errorCode;


}
