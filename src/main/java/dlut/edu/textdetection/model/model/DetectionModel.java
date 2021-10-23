package dlut.edu.textdetection.model.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/23 21:10
 */
@Data
@Builder
public class DetectionModel {
    /**
     * 检测出的关键词
     */
    private String word;
    /**
     * 关键词所在行号
     */
    private long lineNumber;
    /**
     * 关键词所在列号
     */
    private int rowNumber;
    /**
     * 匹配规则对应的key
     */
    private String ruleKey;

}
