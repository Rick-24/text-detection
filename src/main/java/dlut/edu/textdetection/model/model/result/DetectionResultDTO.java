package dlut.edu.textdetection.model.model.result;

import dlut.edu.textdetection.model.model.DetectionModel;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:47
 */
@Data
public class DetectionResultDTO {
    private List<DetectionModel> detectionModels;
}
