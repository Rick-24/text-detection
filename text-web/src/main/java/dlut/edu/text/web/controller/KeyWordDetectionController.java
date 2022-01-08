package dlut.edu.text.web.controller;

import dlut.edu.text.common.result.HttpResult;
import dlut.edu.text.integration.mbg.model.SysKeyword;
import dlut.edu.text.service.result.KeyWordDetectionDTO;
import dlut.edu.text.service.result.request.KeyWordDetectRequest;
import dlut.edu.text.service.result.spec.KeyWordSpec;
import dlut.edu.text.service.service.FileLocalStorageService;
import dlut.edu.text.service.service.KeyWordDetectionService;
import dlut.edu.text.service.service.SysKeyTypeService;
import dlut.edu.text.service.service.SysKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/6 12:09
 */
@RestController
@RequestMapping("detect")
public class KeyWordDetectionController {
    @Autowired
    private FileLocalStorageService fileLocalStorageService;
    @Autowired
    private KeyWordDetectionService keyWordDetectionService;
    @Autowired
    private SysKeyTypeService sysKeyTypeService;
    
    @PostMapping("keyword")
    HttpResult keyWordDetect(Long typeId, @RequestBody MultipartFile file) {
        String filePath = fileLocalStorageService.fileStorageToBeDetected(file);
        List<SysKeyword> sysKeyWords = sysKeyTypeService.getKeyWords(typeId);
        List<String> keyWords = sysKeyWords.stream().map(SysKeyword::getValue).collect(Collectors.toList());
        KeyWordDetectRequest request = KeyWordDetectRequest.builder()
                .typeId(typeId)
                .filePath(filePath)
                .keywords(keyWords)
                .build();
        KeyWordDetectionDTO<KeyWordSpec> resultDTO = keyWordDetectionService.keyWordDetect(request);
        return HttpResult.ok(resultDTO);
    }
}
