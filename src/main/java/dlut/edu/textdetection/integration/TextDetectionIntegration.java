package dlut.edu.textdetection.integration;


import com.alibaba.fastjson.JSON;
import dlut.edu.textdetection.integration.request.TextDetectionRequest;
import dlut.edu.textdetection.integration.util.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

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

        try {
            Socket socket = new Socket("localhost", 2452);
            //得到一个输出流，用于向服务器发送数据
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(JSON.toJSONString(request).getBytes(StandardCharsets.UTF_8));
            //刷新缓冲
            outputStream.flush();
            //得到一个输入流，用于接收服务器响应的数据
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1];
            String info = "";
            while (true) {
                if (inputStream.available() > 0) {
                    inputStream.read(bytes);
                    String hexStr = ByteArrayToHexStr(bytes);
                    info += HexStrToStr(hexStr);
                    //已经读完
                    if (inputStream.available() == 0) {
                        System.out.println("收到来自服务端的信息:" + info);
                        return info;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // httpService.sendMsg("http://localhost:2452",JSON.toJSONString(request));
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



    /**
     * byte[]转16进制Str
     *
     * @param byteArray
     */
    public static String ByteArrayToHexStr(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[byteArray.length * 2];
        for (int i = 0; i < byteArray.length; i++) {
            int temp = byteArray[i] & 0xFF;
            hexChars[i * 2] = hexArray[temp >>> 4];
            hexChars[i * 2 + 1] = hexArray[temp & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * 16进制的Str转Str
     *
     * @param hexStr
     * @return
     */
    public static String HexStrToStr(String hexStr) {
        //能被16整除,肯定可以被2整除
        byte[] array = new byte[hexStr.length() / 2];
        try {
            for (int i = 0; i < array.length; i++) {
                array[i] = (byte) (0xff & Integer.parseInt(hexStr.substring(i * 2, i * 2 + 2), 16));
            }
            hexStr = new String(array, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return hexStr;
    }

}


