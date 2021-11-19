package dlut.edu.textdetection.controller;

import dlut.edu.textdetection.model.enums.AreaEnum;
import dlut.edu.textdetection.model.model.DetectionModel;
import dlut.edu.textdetection.model.model.result.DetectionResultDTO;
import dlut.edu.textdetection.model.result.InvokeResult;
import dlut.edu.textdetection.service.FileLocalStorageService;
import dlut.edu.textdetection.service.RuleSearchService;
import dlut.edu.textdetection.service.TextDetectionService;
import dlut.edu.textdetection.utils.InvokeResultUtils;
import dlut.edu.textdetection.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public InvokeResult<DetectionResultDTO> fileDetectV2(Long areaCode, @RequestParam(value = "matchList", required = false) List<Long> matchList, @RequestParam("file") MultipartFile file) {

        try {
            Map<AreaEnum, List<String>> sysRuleMap = ruleSearchService.getSysRuleAndAboveFilePath(areaCode);
            String savedPath = fileLocalStorageService.fileStorageToBeDetected(file);
            DetectionResultDTO result = textDetectionService.processLocalFile(savedPath, sysRuleMap);
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

