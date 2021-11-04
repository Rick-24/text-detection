package dlut.edu.textdetection.integration;


import com.alibaba.fastjson.JSON;
import dlut.edu.textdetection.integration.request.TextDetectionRequest;
import dlut.edu.textdetection.integration.util.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

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

    public String textDetectionInvoke(TextDetectionRequest request) {
        return httpService.POST4Object("127.0.0.1:2452/textDetection", request);
    }


}


