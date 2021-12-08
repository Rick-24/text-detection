package dlut.edu.text.core.service;


import dlut.edu.text.common.consts.AreaEnum;
import dlut.edu.text.core.convert.DetectionResultConvert;
import dlut.edu.text.integration.python.TextDetectionIntegration;
import dlut.edu.text.integration.python.request.TextDetectionRequest;
import dlut.edu.text.integration.python.response.DetectionResultDO;
import dlut.edu.text.service.result.DetectionResultDTO;
import dlut.edu.text.service.service.TextDetectionService;
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
