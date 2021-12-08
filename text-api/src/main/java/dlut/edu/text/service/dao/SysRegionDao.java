package dlut.edu.text.service.dao;


import dlut.edu.text.integration.mbg.model.SysRegion;

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
     * @param id
     * @return
     */
    List<SysRegion> getSubRegionById(Long id);

}
