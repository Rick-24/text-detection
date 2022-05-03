package dlut.edu.text.web.controller;

import dlut.edu.text.common.result.HttpResult;
import dlut.edu.text.common.result.InvokeResult;
import dlut.edu.text.common.utils.InvokeResultUtils;
import dlut.edu.text.common.utils.LogUtils;
import dlut.edu.text.integration.mbg.model.SysDetectLog;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.result.DetectionResultDTO;
import dlut.edu.text.service.service.FileLocalStorageService;
import dlut.edu.text.service.service.SysDetectLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/5/2 20:12
 */
@RestController
@RequestMapping("detectLog")
@Slf4j
public class SysDetectLogController {
    @Autowired
    private SysDetectLogService sysDetectLogService;
    
    @Autowired
    private FileLocalStorageService fileLocalStorageService;
    
    @PreAuthorize("hasAuthority('sys:log:delete')")
    @PostMapping(value="delete")
    public HttpResult delete(@RequestBody List<SysDetectLog> records) {
        return HttpResult.ok(sysDetectLogService.delete(records));
    }
    
    
    @PreAuthorize("hasAuthority('sys:log:view')")
    @PostMapping(value="findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        System.out.println(pageRequest.getParams());
        return HttpResult.ok(sysDetectLogService.findPage(pageRequest));
    }
    
    @PreAuthorize("hasAuthority('sys:log:detail')")
    @GetMapping(value = "detail")
    public InvokeResult<DetectionResultDTO> detail(String resultPath) {
        try {
            DetectionResultDTO result = fileLocalStorageService.fileRead(DetectionResultDTO.class, resultPath);
            return InvokeResultUtils.buildSuccessInvokeResult(result);
        } catch (Exception e) {
            LogUtils.error(log, e);
            return InvokeResultUtils.buildFailedInvokeResult(e);
        }
    }
}
