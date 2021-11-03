package dlut.edu.textdetection.model.model.spec;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:15
 */
@Data
public class UserInputSpec {
    /**
     * 输入原话
     */
    private String sentence;
    /**
     * 关键词
     */
    private List<String> keywords;
    /**
     * 第几条
     */
    private int number;
    /**
     * 第几段
     */
    private int duan;
    /**
     * 第几句
     */
    private int ju;
}
