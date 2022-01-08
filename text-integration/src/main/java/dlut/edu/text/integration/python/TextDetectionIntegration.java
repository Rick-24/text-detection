package dlut.edu.text.integration.python;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import dlut.edu.text.integration.common.HttpService;
import dlut.edu.text.integration.python.request.KeyWordDetectionRequest;
import dlut.edu.text.integration.python.request.TextDetectionRequest;
import dlut.edu.text.integration.python.response.DetectionResultDO;
import dlut.edu.text.integration.python.response.KeyWordDetectionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/1 22:38
 */
@Service
public class TextDetectionIntegration {
    @Autowired
    private HttpService httpService;

    public DetectionResultDO textDetectionInvoke(TextDetectionRequest request) {
        String result = httpService.POST4Object("127.0.0.1:2452/textDetection", request);
        return JSON.parseObject(result, new TypeReference<DetectionResultDO>() {
        });
    }
    
    public KeyWordDetectionDO keyWordDetectionInvoke(KeyWordDetectionRequest request) {
        System.out.println(request);
        String result = httpService.POST4Object("127.0.0.1:2452/detect/keyword", request);
        return JSON.parseObject(result,new TypeReference<KeyWordDetectionDO>() {});
        
    }


}


