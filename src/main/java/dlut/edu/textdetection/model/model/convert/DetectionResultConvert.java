package dlut.edu.textdetection.model.model.convert;

import dlut.edu.textdetection.model.model.DetectionModel;
import dlut.edu.textdetection.model.model.intergration.DetectionResultDO;
import dlut.edu.textdetection.model.model.result.DetectionResultDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:45
 */
public class DetectionResultConvert {
    public static DetectionResultDTO convert2DetectionResultDTO(List<DetectionResultDO> detectionResultDOs){
        DetectionResultDTO resultDTO = new DetectionResultDTO();

        detectionResultDOs.stream()
                .map(DetectionResultConvert::build)
                .forEach(resultDTO.getDetectionModels()::add);

        return resultDTO;
    }

    public static DetectionModel build(DetectionResultDO detectionResultDO) {
        DetectionModel detectionModel = new DetectionModel();
        detectionModel.setText(detectionResultDO.getWarehouse().getSentence());
        detectionModel.setStartColumn(detectionResultDO.getUserinput().getNumber());
        return detectionModel;
    }
}
