package dlut.edu.textdetection.model.response;

import dlut.edu.textdetection.model.model.DetectionModel;
import dlut.edu.textdetection.model.model.RuleModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/23 21:05
 */
@Data
public class TextDetectionDTO implements Serializable {

    private static final long serialVersionUID = -8800015242842589277L;

    List<DetectionModel> detectionModelList;

    Map<String, RuleModel> ruleModelMap;
}
