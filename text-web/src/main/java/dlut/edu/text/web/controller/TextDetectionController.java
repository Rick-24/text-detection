package dlut.edu.text.web.controller;


import dlut.edu.text.common.result.InvokeResult;
import dlut.edu.text.common.utils.InvokeResultUtils;
import dlut.edu.text.common.utils.LogUtils;
import dlut.edu.text.integration.mbg.model.SysDetectLog;
import dlut.edu.text.service.result.DetectionResultDTO;
import dlut.edu.text.service.service.FileLocalStorageService;
import dlut.edu.text.service.service.RuleSearchService;
import dlut.edu.text.service.service.SysDetectLogService;
import dlut.edu.text.service.service.TextDetectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("text/detection")
public class TextDetectionController {

    @Autowired
    private TextDetectionService textDetectionService;

    @Autowired
    private FileLocalStorageService fileLocalStorageService;

    @Autowired
    private RuleSearchService ruleSearchService;

    @Autowired
    private SysDetectLogService sysDetectLogService;
    @RequestMapping("text")
    public InvokeResult<DetectionResultDTO> textDetect(@RequestBody String text) {
        validate(text);
        try {
            DetectionResultDTO result = textDetectionService.process(text);
            // LogUtils.info(log,"result:",new Object[]{text});
            return InvokeResultUtils.buildSuccessInvokeResult(result);
        } catch (Exception e) {
            LogUtils.error(log, e);
            return InvokeResultUtils.buildFailedInvokeResult(e);
        }
    }


    @RequestMapping("file")
    public InvokeResult<DetectionResultDTO> fileDetect(@RequestBody MultipartFile file) {

        try {
            String savedPath = fileLocalStorageService.fileStorageToBeDetected(file);
            DetectionResultDTO result = textDetectionService.processLocalFile(savedPath);
            return InvokeResultUtils.buildSuccessInvokeResult(result);
        } catch (Exception e) {
            LogUtils.error(log, e);
            return InvokeResultUtils.buildFailedInvokeResult(e);
        }
    }

    @RequestMapping("fileV2")
    public InvokeResult<DetectionResultDTO> fileDetectV2(String userName, @RequestParam("file") MultipartFile file) {
        try {
            // Map<AreaEnum, List<String>> sysRuleMap = ruleSearchService.getSysRuleAndAboveFilePath(areaCode);
            String savedPath = fileLocalStorageService.fileStorageToBeDetected(file);
            DetectionResultDTO result = textDetectionService.processLocalFile(savedPath);
            
            String originalFilename = file.getOriginalFilename();
            String resultPath = fileLocalStorageService.resultStorage(result, originalFilename);
    
            SysDetectLog sysDetectLog = new SysDetectLog();
            sysDetectLog.setFilename(originalFilename);
            sysDetectLog.setFilepath(savedPath);
            sysDetectLog.setUsername(userName);
            sysDetectLog.setDate(LocalDateTime.now());
            sysDetectLog.setResultpath(resultPath);
            sysDetectLogService.save(sysDetectLog);
            
            // todo 是不是需要排个序
            return InvokeResultUtils.buildSuccessInvokeResult(result);
        } catch (Exception e) {
            LogUtils.error(log, e);
            return InvokeResultUtils.buildFailedInvokeResult(e);
        }
    }

    /**
     * 请求入参前置校验
     *
     * @param text
     */
    private void validate(String text) {
        // 校验逻辑
    }

}

