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
public class DetectionModel {
    /**
     * 展示文案（对应规则）
     */
    private String text;
    /**
     * 输入文本（需高亮展示部分）
     */
    private String input;
    /**
     * 输入文本段号
     */
    private int segmentNum;
    /**
     * 输入文本句子号
     */
    private int sentenceNum;

}
