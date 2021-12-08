package dlut.edu.text.integration.python.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:18
 */
@Data
public class DetectionResultDO implements Serializable {

    private static final long serialVersionUID = 5009429069945912675L;


    @JSONField(name = "DISTRICT")
    private List<RegionResultDO> district;
    @JSONField(name = "CITY")
    private List<RegionResultDO> city;
    @JSONField(name = "PROVINCE")
    private List<RegionResultDO> province;

}
