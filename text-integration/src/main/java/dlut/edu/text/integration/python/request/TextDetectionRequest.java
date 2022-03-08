package dlut.edu.text.integration.python.request;

import dlut.edu.text.common.consts.AreaEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/1 22:50
 */
@Data
@Builder
public class TextDetectionRequest implements Serializable {
    private static final long serialVersionUID = -410196527637944297L;
    /**
     * 上传文件路径
     */
    private String filePath;
    
    /**
     * 待匹配文件类别
     */
    private String category;

    /**
     * 上级文件路径
     */
    private Map<AreaEnum, List<String>> sysRuleMap;
}
