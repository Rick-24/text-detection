package dlut.edu.textdetection.model.model.result;

import dlut.edu.textdetection.model.model.RegionModel;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 17:52
 */
@Data
public class RegionIndexDTO {
    private List<RegionModel> models;
}
