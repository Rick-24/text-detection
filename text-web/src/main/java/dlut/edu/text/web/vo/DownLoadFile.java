package dlut.edu.text.web.vo;

import lombok.Data;
import org.springframework.core.io.ByteArrayResource;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/5/2 17:39
 */
@Data
public class DownLoadFile {
    private ByteArrayResource data;
    private String fileName;
}
