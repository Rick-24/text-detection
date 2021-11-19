package dlut.edu.textdetection.model.model.result;

import dlut.edu.textdetection.model.model.DetectionModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:47
 */
@Data
public class DetectionResultDTO {
    private List<DetectionModel> provinceModel;
    private List<DetectionModel> cityModel;
    private List<DetectionModel> districtModel;

    public DetectionResultDTO(){
        provinceModel = new ArrayList<>();
        cityModel = new ArrayList<>();
        districtModel = new ArrayList<>();
    }
}
