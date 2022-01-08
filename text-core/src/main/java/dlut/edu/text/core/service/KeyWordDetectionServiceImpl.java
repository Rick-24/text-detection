package dlut.edu.text.core.service;

import dlut.edu.text.core.convert.KeyWordDetectionResultConvert;
import dlut.edu.text.integration.python.TextDetectionIntegration;
import dlut.edu.text.integration.python.request.KeyWordDetectionRequest;
import dlut.edu.text.integration.python.response.KeyWordDetectionDO;
import dlut.edu.text.service.result.KeyWordDetectionDTO;
import dlut.edu.text.service.result.SentenceDTO;
import dlut.edu.text.service.result.request.KeyWordDetectRequest;
import dlut.edu.text.service.result.spec.KeyWordSpec;
import dlut.edu.text.service.service.KeyWordDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 12:15
 */
@Service
public class KeyWordDetectionServiceImpl implements KeyWordDetectionService {
    @Autowired
    private TextDetectionIntegration textDetectionIngration;
    
    @Override
    public KeyWordDetectionDTO<KeyWordSpec> keyWordDetect(KeyWordDetectRequest request) {
        KeyWordDetectionRequest req = new KeyWordDetectionRequest();
        req.setKeywords(request.getKeywords());
        req.setFilePath(request.getFilePath());
        req.setTypeId(request.getTypeId());
        KeyWordDetectionDO keyWordDetectionDO = textDetectionIngration.keyWordDetectionInvoke(req);
        return KeyWordDetectionResultConvert.convert2DTO(keyWordDetectionDO);
    }
}
