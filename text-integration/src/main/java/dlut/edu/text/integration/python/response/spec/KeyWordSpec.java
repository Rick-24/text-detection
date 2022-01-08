package dlut.edu.text.integration.python.response.spec;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 14:47
 */
@Data
public class KeyWordSpec {
    @JSONField(name = "sentence_num")
    Integer sentenceNum;
    @JSONField(name = "segment_num")
    Integer segmentNum;
    @JSONField(name = "word")
    String keyWord;
    @JSONField(name = "text")
    String text;
}
