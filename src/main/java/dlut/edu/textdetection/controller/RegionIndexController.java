package dlut.edu.textdetection.controller;

import dlut.edu.textdetection.model.model.RegionModel;
import dlut.edu.textdetection.model.model.result.DetectionResultDTO;
import dlut.edu.textdetection.model.model.result.RegionIndexDTO;
import dlut.edu.textdetection.model.result.InvokeResult;
import dlut.edu.textdetection.service.RegionIndexService;
import dlut.edu.textdetection.utils.InvokeResultUtils;
import dlut.edu.textdetection.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/15 17:49
 */
@Slf4j
@RestController
@RequestMapping("area")
public class RegionIndexController {
    @Autowired
    private RegionIndexService regionIndexService;

    @RequestMapping("province")
    public InvokeResult<RegionIndexDTO> province() {
        try {
            List<RegionModel> regionModels = regionIndexService.getAllProvince();
            RegionIndexDTO result = new RegionIndexDTO();
            result.setModels(regionModels);
            return InvokeResultUtils.buildSuccessInvokeResult(result);
        } catch (Exception e) {
            LogUtils.error(log, e);
            return InvokeResultUtils.buildFailedInvokeResult(e);
        }
    }

    // @RequestMapping("city")
    // public InvokeResult<RegionIndexDTO> city(Long id) {
    //     try {
    //         List<RegionModel> regionModels = regionIndexService.getSubRegionById(id);
    //         RegionIndexDTO result = new RegionIndexDTO();
    //         result.setModels(regionModels);
    //         return InvokeResultUtils.buildSuccessInvokeResult(result);
    //     } catch (Exception e) {
    //         LogUtils.error(log, e);
    //         return InvokeResultUtils.buildFailedInvokeResult(e);
    //     }
    // }

    @RequestMapping(path = {"district","city"})
    public InvokeResult<RegionIndexDTO> district(@NonNull Long id) {
        try {
            List<RegionModel> regionModels = regionIndexService.getSubRegionById(id);
            RegionIndexDTO result = new RegionIndexDTO();
            result.setModels(regionModels);
            return InvokeResultUtils.buildSuccessInvokeResult(result);
        } catch (Exception e) {
            LogUtils.error(log, e);
            return InvokeResultUtils.buildFailedInvokeResult(e);
        }
    }

}
