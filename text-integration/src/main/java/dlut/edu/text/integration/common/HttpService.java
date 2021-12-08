package dlut.edu.text.integration.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/1 22:47
 */
@Service("localHttpService")
public class HttpService {

    @Autowired
    private RestTemplate restTemplate;

    public String GET(String uri,Supplier<Map<String,String>> paramsSupplier){
        return GET("http",uri,paramsSupplier);
    }

    public String GET(String protocol, String uri, Supplier<Map<String, String>> paramsSupplier) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                generateRequestParameters(protocol, uri, paramsSupplier.get()), String.class);
        return responseEntity.getBody();
    }


    /**
     * post请求
     * @return
     */
    public String POST(String protocol,String uri,Supplier<Map<String,String>> body) {
        ResponseEntity<String> apiResponse = restTemplate.postForEntity(
                protocol+"://"+uri, generatePostJson(body.get()), String.class);
        return apiResponse.getBody();
    }

    public String POST(String uri,Supplier<Map<String,String>> body){
        return POST("http",uri,body);
    }

    public String POST4Object(String uri,Object postObject){
        return POST4Object("http",uri,postObject);
    }
    public String POST4Object(String protocol,String uri,Object postObject){
        return restTemplate.postForObject(protocol+"://"+uri,postObject,String.class);
    }

    public String generateRequestParameters(String protocol, String uri, Map<String, String> params) {
        StringBuilder sb = new StringBuilder(protocol).append("://").append(uri);
        if (!CollectionUtils.isEmpty(params)) {
            sb.append("?");
            for (Map.Entry<String,String> map : params.entrySet()) {
                sb.append(map.getKey())
                        .append("=")
                        .append(map.getValue())
                        .append("&");
            }
            uri = sb.substring(0, sb.length() - 1);
            return uri;
        }
        return sb.toString();
    }

    public HttpEntity<Map<String, String>> generatePostJson(Map<String, String> jsonMap) {
        //如果需要其它的请求头信息、都可以在这里追加
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");

        httpHeaders.setContentType(type);
        return new HttpEntity<>(jsonMap, httpHeaders);
    }

}
