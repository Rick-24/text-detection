package dlut.edu.text.service.service;

import dlut.edu.text.service.result.KeyWordDetectionDTO;
import dlut.edu.text.service.result.request.KeyWordDetectRequest;
import dlut.edu.text.service.result.spec.KeyWordSpec;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 12:15
 */
public interface KeyWordDetectionService {
    /**
     * 关键词检测
     * @param request
     * @return
     */
    KeyWordDetectionDTO<KeyWordSpec> keyWordDetect(KeyWordDetectRequest request);
}
