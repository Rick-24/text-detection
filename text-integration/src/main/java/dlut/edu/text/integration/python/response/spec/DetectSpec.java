package dlut.edu.text.integration.python.response.spec;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/3/8 16:41
 */
@Data
public class DetectSpec {
    /**
     * 检测文件所在段数
     */
    @JSONField(name ="segment_num" )
    private Integer segmentNum;
    /**
     * 检测文件所在句子数
     */
    @JSONField(name = "sentence_num")
    private Integer sentenceNum;
    /**
     * 检测文件文本
     */
    @JSONField(name = "text")
    private String text;
    /**
     * 检测文件路径
     */
    @JSONField(name = "path")
    private String path;
    /**
     * 检测文件类型
     */
    @JSONField(name = "type")
    private String type;
}
