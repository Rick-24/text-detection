package dlut.edu.textdetection.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import dlut.edu.textdetection.integration.TextDetectionIntegration;
import dlut.edu.textdetection.integration.request.TextDetectionRequest;
import dlut.edu.textdetection.model.enums.AreaEnum;
import dlut.edu.textdetection.model.model.convert.DetectionResultConvert;
import dlut.edu.textdetection.model.model.intergration.DetectionResultDO;
import dlut.edu.textdetection.model.model.result.DetectionResultDTO;
import dlut.edu.textdetection.service.TextDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/19 21:06
 */
@Service
public class TextDetectionServiceImpl implements TextDetectionService {

    @Autowired
    private TextDetectionIntegration textDetectionIntegration;

    @Override
    public DetectionResultDTO process(String text) {

        return null;
    }

    @Override
    public DetectionResultDTO processLocalFile(String filePath) {
        TextDetectionRequest request = TextDetectionRequest.builder()
                .filePath(filePath)
                .build();
        DetectionResultDO detectionResult = textDetectionIntegration.textDetectionInvoke(request);
        return DetectionResultConvert.convert2DetectionResultDTO(detectionResult);

    }

    @Override
    public DetectionResultDTO processLocalFile(String filePath, Map<AreaEnum, List<String>> sysRuleMap) {
        TextDetectionRequest request = TextDetectionRequest.builder()
                .filePath(filePath)
                .sysRuleMap(sysRuleMap)
                .build();

        DetectionResultDO detectionResult = textDetectionIntegration.textDetectionInvoke(request);
        return DetectionResultConvert.convert2DetectionResultDTO(detectionResult);

    }
}
