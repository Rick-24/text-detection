package dlut.edu.text.integration.python.response;

import com.alibaba.fastjson.annotation.JSONField;

import dlut.edu.text.integration.python.response.spec.RuleSpec;
import dlut.edu.text.integration.python.response.spec.UserInputSpec;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/17 18:47
 */
@Data
public class RuleResultDO implements Serializable {
    private static final long serialVersionUID = -7268234951628163545L;
    /**
     * 规则描述
     */
    @JSONField(name = "warehouse")
    private RuleSpec ruleSpec;
    /**
     * 用户输入描述
     */
    @JSONField(name = "userinput")
    private UserInputSpec userInputSpec;
    /**
     * 关键词匹配个数
     */
    @JSONField(name = "keyword_match")
    private int keywordMatch;
    /**
     * 匹配程度
     */
    @JSONField(name = "matching_degree")
    private int matchingDegree;
    /**
     *
     */
    @JSONField(name = "similarity")
    private double similarity;

}
