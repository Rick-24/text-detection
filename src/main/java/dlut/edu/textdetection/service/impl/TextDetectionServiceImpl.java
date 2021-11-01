package dlut.edu.textdetection.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import dlut.edu.textdetection.integration.TextDetectionIntegration;
import dlut.edu.textdetection.integration.request.TextDetectionRequest;
import dlut.edu.textdetection.model.model.convert.DetectionResultConvert;
import dlut.edu.textdetection.model.model.intergration.DetectionResultDO;
import dlut.edu.textdetection.model.model.result.DetectionResultDTO;
import dlut.edu.textdetection.service.TextDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //todo
        // PythonInterpreter interpreter = new PythonInterpreter();
        //
        // String fileName = Optional.ofNullable(this.getClass().getClassLoader().getResource("python/test.py"))
        //         .map(URL::getPath).get();
        //
        // interpreter.execfile(fileName);
        //
        // PyFunction pyFunction = interpreter.get("process", PyFunction.class);
        // PyObject pyobj = pyFunction.__call__(new PyString(text));
        String json = "[{'warehouse': {'sentence': '对年度实现规模以上工业总产值在全区排前五名的街道，分别奖励50万元、40万元、30万元、20万元、10万元',\n" +
                "   'keywords': ['工业', '总产值', '规模', '实现', '全区', '街道', '年度', '奖励'],\n" +
                "   'zhang': '第五章',\n" +
                "   'tiao': '第四条'},\n" +
                "  'userinput': {'sentence': '每年工业总产值在全区排前二十名的街道，分别奖励50万元、30万元、20万元',\n" +
                "   'keywords': ['全区', '街道', '总产值', '工业', '奖励'],\n" +
                "   'number': 2},\n" +
                "  'match_count': 5,\n" +
                "  'matching_degree': 2}]";

        List<DetectionResultDO> detectionResult = JSON.parseObject(json, new TypeReference<List<DetectionResultDO>>() {});
        return DetectionResultConvert.convert2DetectionResultDTO(detectionResult);
    }

    @Override
    public DetectionResultDTO processLocalFile(String filePath) {
        TextDetectionRequest request = new TextDetectionRequest();
        request.setFilePath(filePath);
        String result = textDetectionIntegration.textDetectionInvoke(request);
        List<DetectionResultDO> detectionResult = JSON.parseObject(result, new TypeReference<List<DetectionResultDO>>() {});
        return DetectionResultConvert.convert2DetectionResultDTO(detectionResult);

    }
}
