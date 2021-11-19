package dlut.edu.textdetection.service;

import dlut.edu.textdetection.model.model.RegionModel;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 18:33
 */
public interface RegionIndexService {
    List<RegionModel> getAllProvince();

    List<RegionModel> getSubRegionById(Long id);
}
