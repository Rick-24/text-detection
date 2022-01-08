package dlut.edu.text.integration.python.request;

import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 14:53
 */
@Data
public class KeyWordDetectionRequest {
    Long typeId;
    String filePath;
    List<String> keywords;
}
