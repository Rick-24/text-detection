package dlut.edu.textdetection.service;

/**
 * Created by IntelliJ IDEA.
 * @Author : hongwei.zhw
 * @create 2021/10/19 21:06
 */
public interface TextDetectionService {
    /**
     * 文本合规性检测
     * @param text
     */
    void process(String text);
}
