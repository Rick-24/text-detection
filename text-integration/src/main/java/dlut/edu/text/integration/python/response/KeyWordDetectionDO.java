package dlut.edu.text.integration.python.response;

import com.alibaba.fastjson.annotation.JSONField;
import dlut.edu.text.integration.python.response.spec.KeyWordSpec;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 14:45
 */
@Data
public class KeyWordDetectionDO {
    @JSONField(name = "keyWords")
    List<KeyWordSpec> keyWordSpecs;
}
