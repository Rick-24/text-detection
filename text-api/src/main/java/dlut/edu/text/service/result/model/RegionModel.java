package dlut.edu.text.service.result.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 17:52
 */
@Data
@Builder
public class RegionModel {
    /**
     * 地名
     */
    private String name;
    /**
     * 地区码
     */
    private Long code;
    /**
     * id
     */
    private Long id;
}
