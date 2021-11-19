package dlut.edu.textdetection.model.model.intergration;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/17 18:50
 */
@Data
public class RegionResultDO implements Serializable {
    private static final long serialVersionUID = -5309878817451614915L;

    @JSONField(name = "filepath_input")
    private String filepathInput;

    @JSONField(name = "filepath_rule")
    private String filepathRule;

    @JSONField(name = "match_list")
    private List<RuleResultDO> matchList;

}
