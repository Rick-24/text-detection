package dlut.edu.textdetection.model.model.convert;

import dlut.edu.textdetection.model.enums.AreaEnum;
import dlut.edu.textdetection.model.model.DetectionModel;
import dlut.edu.textdetection.model.model.SentenceModel;
import dlut.edu.textdetection.model.model.intergration.DetectionResultDO;
import dlut.edu.textdetection.model.model.intergration.RegionResultDO;
import dlut.edu.textdetection.model.model.intergration.RuleResultDO;
import dlut.edu.textdetection.model.model.result.DetectionResultDTO;
import dlut.edu.textdetection.model.model.spec.ResultSpec;
import dlut.edu.textdetection.model.model.spec.SentenceSpec;

import java.util.*;
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

        List<DetectionModel> city = detectionResultDO.getCity().stream()
                .map(DetectionResultConvert::buildDetectionModel)
                .filter(detectionModel -> !detectionModel.getFileResult().isEmpty())
                .collect(Collectors.toList());
        List<DetectionModel> district = detectionResultDO.getDistrict().stream()
                .map(DetectionResultConvert::buildDetectionModel)
                .filter(detectionModel -> !detectionModel.getFileResult().isEmpty())
                .collect(Collectors.toList());
        HashMap<String, SentenceModel> sentenceModelMap = new HashMap<>();
        province.forEach(detectionModel -> processDetectionModel(detectionModel, sentenceModelMap));
        district.forEach(detectionModel -> processDetectionModel(detectionModel, sentenceModelMap));
        city.forEach(detectionModel -> processDetectionModel(detectionModel, sentenceModelMap));

        resultDTO.getProvinceModel().addAll(province);
        resultDTO.getCityModel().addAll(city);
        resultDTO.getDistrictModel().addAll(district);
        resultDTO.getSentenceModel().addAll(sentenceModelMap.values());
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
        detectionModel.setRuleFilePath(rulePath);
        return detectionModel;
    }

    public static ResultSpec buildResultSpec(RuleResultDO ruleResultDO) {
        ResultSpec spec = new ResultSpec();
        spec.setInput(ruleResultDO.getUserInputSpec().getSentence());
        spec.setInputSegment(ruleResultDO.getUserInputSpec().getDuan() - 1);
        spec.setInputSentenceNum(ruleResultDO.getUserInputSpec().getJu());
        spec.setText(ruleResultDO.getRuleSpec().getSentence());
        spec.setRuleSegment(ruleResultDO.getRuleSpec().getDuan());
        spec.setRuleSentenceNum(ruleResultDO.getRuleSpec().getJu());
        spec.setSimilarity(ruleResultDO.getSimilarity());
        return spec;
    }

    public static SentenceSpec buildSentenceSpec(ResultSpec resultSpec, String ruleFilePath) {
        String ruleName = ruleFilePath.substring(ruleFilePath.lastIndexOf('/') + 1, ruleFilePath.lastIndexOf('.') - 1);
        SentenceSpec spec = new SentenceSpec();
        spec.setRuleFilePath(ruleFilePath);
        spec.setSimilarity(resultSpec.getSimilarity());
        spec.setRuleName(ruleName);
        spec.setRuleSegmentNum(resultSpec.getRuleSegment());
        spec.setRuleSentenceNum(resultSpec.getRuleSentenceNum());
        return spec;
    }

    public static void processDetectionModel(DetectionModel detectionModel, HashMap<String, SentenceModel> sentenceModelMap) {
        String ruleFilePath = detectionModel.getRuleFilePath();
        detectionModel.getFileResult()
                .forEach(resultSpec -> sentenceModelMap.computeIfAbsent(resultSpec.getInputPosition(),
                        k -> new SentenceModel(resultSpec.getInput(), resultSpec.getInputSegment(), resultSpec.getInputSegment()))
                        .getSentenceSpecList().add(buildSentenceSpec(resultSpec, ruleFilePath)));
    }
}
