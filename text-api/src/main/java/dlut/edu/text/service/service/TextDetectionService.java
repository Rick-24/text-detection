package dlut.edu.text.service.service;

import dlut.edu.text.common.consts.AreaEnum;
import dlut.edu.text.service.result.DetectionResultDTO;


import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/19 21:06
 */
public interface TextDetectionService {
    /**
     * 文本合规性检测
     *
     * @param text
     */
    DetectionResultDTO process(String text);

    /**
     * 本地文本合规性检测
     */
    DetectionResultDTO processLocalFile(String filePath);

    /**
     * 本地文本合规性检测
     * @param filePath 文件地址
     * @param sysRuleMap 上级文件地址
     * @return
     */
    DetectionResultDTO processLocalFile(String filePath, Map<AreaEnum, List<String>> sysRuleMap);
}
