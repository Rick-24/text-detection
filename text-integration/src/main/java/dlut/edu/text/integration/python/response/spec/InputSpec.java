package dlut.edu.text.integration.python.response.spec;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/3/8 16:35
 */
@Data
public class InputSpec {
    /**
     * 原文输入
     */
    @JSONField(name = "text")
    private String text;
    /**
     * 原文所在段数
     */
    @JSONField(name = "segment_num")
    private Integer segmentNum;
    /**
     * 原文所在句子数
     */
    @JSONField(name = "sentence_num")
    private Integer sentenceNum;
}
