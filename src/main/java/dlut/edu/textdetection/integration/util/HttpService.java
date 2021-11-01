package dlut.edu.textdetection.integration.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/1 22:47
 */
@Service("localHttpService")
public class HttpService {

    private static final Logger logger = LoggerFactory.getLogger(HttpService.class);

    /**
     * 发送数据到指定的地址
     *
     * @param url  发送地址
     * @param body 发送内容
     */
    public void sendMsg(String url, Object body) {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(2000)
                .setConnectTimeout(2000)
                .setConnectionRequestTimeout(5000)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();
        //        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeaders(HttpClientBuilder.getHeaders());
        post.setConfig(HttpClientBuilder.getDefaultRequestConfig());
        HttpEntity entry = new StringEntity(JSON.toJSONString(body), "UTF-8");
        post.setEntity(entry);
        CloseableHttpResponse response;
        try {
            response = httpClient.execute(post);
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("发送数据失败, {}", e.getMessage());
        }
    }

    /**
     * 发送数据到指定的地址
     *
     * @param url  发送地址
     * @param body 发送内容
     */
    public void sendMsg(String url, String body) {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(2000)
                .setConnectTimeout(2000)
                .setConnectionRequestTimeout(5000)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeaders(HttpClientBuilder.getHeaders());
        post.setConfig(HttpClientBuilder.getDefaultRequestConfig());
        HttpEntity entry = new StringEntity(body, "UTF-8");
        post.setEntity(entry);
        CloseableHttpResponse response;
        try {
            response = httpClient.execute(post);
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("发送数据失败, {}", e.getMessage());
        }
    }

}
