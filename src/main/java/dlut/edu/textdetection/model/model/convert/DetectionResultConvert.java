package dlut.edu.textdetection.model.model.convert;

import dlut.edu.textdetection.model.enums.AreaEnum;
import dlut.edu.textdetection.model.model.DetectionModel;
import dlut.edu.textdetection.model.model.intergration.DetectionResultDO;
import dlut.edu.textdetection.model.model.intergration.RegionResultDO;
import dlut.edu.textdetection.model.model.intergration.RuleResultDO;
import dlut.edu.textdetection.model.model.result.DetectionResultDTO;
import dlut.edu.textdetection.model.model.spec.ResultSpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:45
 */
public class DetectionResultConvert {
    public static DetectionResultDTO convert2DetectionResultDTO(DetectionResultDO detectionResultDO) {
        DetectionResultDTO resultDTO = new DetectionResultDTO();

        List<DetectionModel> province = detectionResultDO.getProvince().stream()
                .map(DetectionResultConvert::buildDetectionModel)
                .filter(detectionModel -> !detectionModel.getFileResult().isEmpty())
                .collect(Collectors.toList());
        resultDTO.getProvinceModel().addAll(province);

        List<DetectionModel> city = detectionResultDO.getCity().stream()
                .map(DetectionResultConvert::buildDetectionModel)
                .filter(detectionModel -> !detectionModel.getFileResult().isEmpty())
                .collect(Collectors.toList());
        resultDTO.getCityModel().addAll(city);
        List<DetectionModel> district = detectionResultDO.getDistrict().stream()
                .map(DetectionResultConvert::buildDetectionModel)
                .filter(detectionModel -> !detectionModel.getFileResult().isEmpty())
                .collect(Collectors.toList());
        resultDTO.getDistrictModel().addAll(district);
        return resultDTO;
    }

    public static DetectionModel buildDetectionModel(RegionResultDO detectionResultDO) {
        DetectionModel detectionModel = new DetectionModel();
        String pattern = ".*\\d.*";
        List<ResultSpec> fileResult = detectionResultDO.getMatchList().stream()
                .map(DetectionResultConvert::buildResultSpec)
                .filter(resultSpec -> Pattern.matches(pattern, resultSpec.getText()))
                .collect(Collectors.toList());
        detectionModel.getFileResult().addAll(fileResult);
        String rulePath = detectionResultDO.getFilepathRule();
        detectionModel.setRuleName(rulePath.substring(rulePath.lastIndexOf('/') + 1, rulePath.lastIndexOf('.') - 1));

        return detectionModel;
    }

    public static ResultSpec buildResultSpec(RuleResultDO ruleResultDO) {
        ResultSpec spec = new ResultSpec();
        spec.setInput(ruleResultDO.getUserInputSpec().getSentence());
        spec.setInputSegment(ruleResultDO.getUserInputSpec().getDuan());
        spec.setInputSentenceNum(ruleResultDO.getUserInputSpec().getJu());
        spec.setText(ruleResultDO.getRuleSpec().getSentence());
        spec.setRuleSegment(ruleResultDO.getRuleSpec().getDuan());
        spec.setRuleSentenceNum(ruleResultDO.getRuleSpec().getJu());
        return spec;
    }
}
