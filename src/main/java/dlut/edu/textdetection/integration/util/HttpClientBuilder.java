package dlut.edu.textdetection.integration.util;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/1 22:44
 */
public class HttpClientBuilder {
    private static final Header[] headers = new Header[]{
            new BasicHeader("charset", "utf-8"),
            new BasicHeader("Content-Type", "application/json")
    };

    /**
     * 获得一个默认的请求配置
     *
     * @return RequestConfig
     */
    public static RequestConfig getDefaultRequestConfig() {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(2000)
                .setConnectTimeout(2000)
                .build();
    }

    /**
     * 简单头信息获取
     *
     * @return 请求头数组
     */
    public static Header[] getHeaders() {
        return headers;
    }
}
