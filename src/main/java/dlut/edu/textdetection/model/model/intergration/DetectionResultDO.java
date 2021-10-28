package dlut.edu.textdetection.model.model.intergration;

import dlut.edu.textdetection.model.model.spec.RuleSpec;
import dlut.edu.textdetection.model.model.spec.UserInputSpec;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:18
 */
@Data
public class DetectionResultDO implements Serializable {

    private static final long serialVersionUID = 5009429069945912675L;

    /**
     * 规则描述
     */
    private RuleSpec warehouse;
    /**
     * 用户输入描述
     */
    private UserInputSpec userinput;
    /**
     *
     */
    private int matchCount;
    /**
     * 匹配程度
     */
    private int matchingDegree;
}
