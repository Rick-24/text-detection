package dlut.edu.textdetection.integration;


import com.alibaba.fastjson.JSON;
import dlut.edu.textdetection.integration.request.TextDetectionRequest;
import dlut.edu.textdetection.integration.util.HttpService;
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

    public String textDetectionInvoke(TextDetectionRequest request) {

        httpService.sendMsg("http://localhost:2452",JSON.toJSONString(request));
        // todo 返回调用结果
        return "[{'warehouse': {'sentence': '对年度实现规模以上工业总产值在全区排前五名的街道，分别奖励50万元、40万元、30万元、20万元、10万元',\n" +
                "   'keywords': ['工业', '总产值', '规模', '实现', '全区', '街道', '年度', '奖励'],\n" +
                "   'zhang': '第五章',\n" +
                "   'tiao': '第四条'},\n" +
                "  'userinput': {'sentence': '每年工业总产值在全区排前二十名的街道，分别奖励50万元、30万元、20万元',\n" +
                "   'keywords': ['全区', '街道', '总产值', '工业', '奖励'],\n" +
                "   'number': 2},\n" +
                "  'match_count': 5,\n" +
                "  'matching_degree': 2}]";
    }

}
