package dlut.edu.textdetection.integration.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/1 22:50
 */
@Data
public class TextDetectionRequest implements Serializable {
    private static final long serialVersionUID = -410196527637944297L;
    /**
     * 上传文件路径
     */
    private String filePath;
}
