package dlut.edu.textdetection.service.impl;

import dlut.edu.textdetection.dao.SysRegionDao;
import dlut.edu.textdetection.mbg.model.SysRegion;
import dlut.edu.textdetection.model.model.RegionModel;
import dlut.edu.textdetection.model.model.result.RegionIndexDTO;
import dlut.edu.textdetection.service.RegionIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 18:39
 */
@Service
public class RegionIndexServiceImpl implements RegionIndexService {
    @Autowired
    private SysRegionDao sysRegionDao;
    @Override
    public List<RegionModel> getAllProvince() {
        List<SysRegion> allProvinces = sysRegionDao.getAllProvinces();
        return allProvinces.stream().map(province->
            RegionModel.builder()
                    .code(province.getCode())
                    .name(province.getName())
                    .id(province.getId())
                    .build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<RegionModel> getSubRegionById(Long id) {
        List<SysRegion> allProvinces = sysRegionDao.getSubRegionById(id);
        return allProvinces.stream().map(province->
                RegionModel.builder()
                        .code(province.getCode())
                        .name(province.getName())
                        .id(province.getId())
                        .build()
        ).collect(Collectors.toList());
    }
}
