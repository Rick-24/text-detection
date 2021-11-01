package dlut.edu.textdetection.service;

import dlut.edu.textdetection.model.model.result.DetectionResultDTO;

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
    DetectionResultDTO process(String text);

    /**
     * 本地文本合规性检测
     */
    DetectionResultDTO processLocalFile(String filePath);
}
