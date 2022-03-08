package dlut.edu.text.integration.python.response;

import com.alibaba.fastjson.annotation.JSONField;
import dlut.edu.text.integration.python.response.spec.DetectSpec;
import dlut.edu.text.integration.python.response.spec.InputSpec;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/3/8 16:33
 */
@Data
public class SentenceResultDO {
    @JSONField(name = "sentence")
    private InputSpec inputSpec;
    @JSONField(name = "match_list")
    private List<DetectSpec> detectSpecs;
}
