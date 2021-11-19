package dlut.edu.textdetection.integration;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import dlut.edu.textdetection.integration.request.TextDetectionRequest;
import dlut.edu.textdetection.integration.util.HttpService;
import dlut.edu.textdetection.model.model.intergration.DetectionResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

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
        return JSON.parseObject(result, new TypeReference<DetectionResultDO>() {});
    }


}


