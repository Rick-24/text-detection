package dlut.edu.text.integration.python.response.spec;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:14
 */
@Data
public class RuleSpec {
    /**
     * 原话
     */
    private String sentence;
    /**
     * 第几段
     */
    private int duan;
    /**
     * 第几句
     */
    private int ju;
}
