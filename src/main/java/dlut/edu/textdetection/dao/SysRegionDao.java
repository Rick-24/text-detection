package dlut.edu.textdetection.dao;

import dlut.edu.textdetection.mbg.model.SysRegion;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/14 16:32
 */
public interface SysRegionDao {
    /**
     * 获取所有省份
     * @return
     */
    List<SysRegion> getAllProvinces();

    /**
     * 根据区域码获取下级地区
     * @param areaCode
     * @return
     */
    List<SysRegion> getSubRegionById(Long id);

}
