package dlut.edu.textdetection.model.model.spec;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/17 23:28
 */
@Data
public class ResultSpec {
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
    private int inputSegment;
    /**
     * 输入文本句子号
     */
    private int inputSentenceNum;
    /**
     * 输入文本段号
     */
    private int ruleSegment;
    /**
     * 输入文本句子号
     */
    private int ruleSentenceNum;

}
