package dlut.edu.textdetection.model.model;

import dlut.edu.textdetection.model.model.spec.ResultSpec;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/23 21:10
 */
@Data
public class DetectionModel {

    /**
     * 规则文件名称
     */
    private String ruleName;
    /**
     * 该文件的匹配规则
     */
    private List<ResultSpec> fileResult;

    public DetectionModel(){
        fileResult = new ArrayList<>();
    }
}
