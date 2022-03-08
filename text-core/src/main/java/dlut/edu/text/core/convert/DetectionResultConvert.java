package dlut.edu.text.core.convert;

import dlut.edu.text.integration.python.response.DetectionResultDO;
import dlut.edu.text.integration.python.response.RegionResultDO;
import dlut.edu.text.integration.python.response.RuleResultDO;
import dlut.edu.text.integration.python.response.SentenceResultDO;
import dlut.edu.text.integration.python.response.spec.DetectSpec;
import dlut.edu.text.integration.python.response.spec.InputSpec;
import dlut.edu.text.service.result.DetectionResultDTO;
import dlut.edu.text.service.result.model.DetectionModel;
import dlut.edu.text.service.result.model.SentenceModel;
import dlut.edu.text.service.result.spec.ResultSpec;
import dlut.edu.text.service.result.spec.SentenceSpec;

import java.util.Comparator;
import java.util.HashMap;
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
        
        List<SentenceModel> sentenceModels = detectionResultDO.getSentenceResultDOS().stream()
                .map(DetectionResultConvert::buildSentenceModel)
                .collect(Collectors.toList());
        resultDTO.getProvinceModel().addAll(province);
        resultDTO.getCityModel().addAll(city);
        resultDTO.getDistrictModel().addAll(district);
        resultDTO.getSentenceModel().addAll(
                sentenceModelMap.values().stream()
                        .sorted(Comparator.comparing(SentenceModel::getSegmentNum)
                                .thenComparing(SentenceModel::getSentenceNum))
                        .collect(Collectors.toList())
        );
        resultDTO.getSentenceModel().addAll(sentenceModels);
        return resultDTO;
    }
    
    public static SentenceModel buildSentenceModel(SentenceResultDO sentenceResultDO) {
        InputSpec inputSpec = sentenceResultDO.getInputSpec();
        SentenceModel sentenceModel = new SentenceModel(
                inputSpec.getText(), inputSpec.getSegmentNum(), inputSpec.getSentenceNum());
        List<DetectSpec> detectSpecs = sentenceResultDO.getDetectSpecs();
        List<SentenceSpec> collect = detectSpecs.stream()
                .map(DetectionResultConvert::buildSentenceSpec)
                .collect(Collectors.toList());
        sentenceModel.getSentenceSpecList().addAll(collect);
        return sentenceModel;
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
        detectionModel.setRuleName(rulePath.substring(rulePath.lastIndexOf('/') + 1, rulePath.lastIndexOf('.')));
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
        String ruleName = ruleFilePath.substring(ruleFilePath.lastIndexOf('/') + 1, ruleFilePath.lastIndexOf('.'));
        SentenceSpec spec = new SentenceSpec();
        spec.setRuleFilePath(ruleFilePath);
        spec.setSimilarity(resultSpec.getSimilarity());
        spec.setRuleName(ruleName);
        spec.setRuleSegmentNum(resultSpec.getRuleSegment());
        spec.setRuleSentenceNum(resultSpec.getRuleSentenceNum());
        spec.setText(resultSpec.getText());
        return spec;
    }
    
    public static SentenceSpec buildSentenceSpec(DetectSpec detectSpec) {
        String ruleFilePath = detectSpec.getPath();
        SentenceSpec spec = new SentenceSpec();
        spec.setRuleFilePath(ruleFilePath);
        spec.setRuleName(ruleFilePath.substring(ruleFilePath.lastIndexOf('/') + 1, ruleFilePath.lastIndexOf('.')));
        spec.setRuleSegmentNum(detectSpec.getSegmentNum());
        spec.setRuleSentenceNum(detectSpec.getSentenceNum());
        spec.setText(detectSpec.getText());
        return spec;
    }
    
    
    public static void processDetectionModel(DetectionModel detectionModel, HashMap<String, SentenceModel> sentenceModelMap) {
        String ruleFilePath = detectionModel.getRuleFilePath();
        detectionModel.getFileResult()
                .forEach(resultSpec -> sentenceModelMap.computeIfAbsent(resultSpec.getInputPosition(),
                                k -> new SentenceModel(resultSpec.getInput(), resultSpec.getInputSegment(), resultSpec.getInputSentenceNum()))
                        .getSentenceSpecList().add(buildSentenceSpec(resultSpec, ruleFilePath)));
    }
}
