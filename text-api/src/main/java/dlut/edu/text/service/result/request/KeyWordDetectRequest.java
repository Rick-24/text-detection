package dlut.edu.text.service.result.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 12:42
 */
@Data
@Builder
public class KeyWordDetectRequest {
    Long typeId;
    String filePath;
    List<String> keywords;
}
