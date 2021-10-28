package dlut.edu.textdetection.model.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/23 21:10
 */
@Data
public class DetectionModel {
    private String text;
    private int startRow;
    private int startColumn;
    private int endRow;
    private int endColumn;

}
