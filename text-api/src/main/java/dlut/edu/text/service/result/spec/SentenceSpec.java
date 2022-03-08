package dlut.edu.text.service.result.spec;

import lombok.Builder;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/19 21:45
 */
@Data
public class SentenceSpec {
    private String ruleName;
    private String ruleFilePath;
    private int ruleSegmentNum;
    private int ruleSentenceNum;
    private String text;
    private double similarity;
}
