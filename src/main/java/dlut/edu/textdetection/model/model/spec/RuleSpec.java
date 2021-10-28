package dlut.edu.textdetection.model.model.spec;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
     * 关键词
     */
    private List<String> keywords;
    /**
     * 第几章
     */
    private String zhang;
    /**
     * 第几条
     */
    private String tiao;
}
