package dlut.edu.text.web.controller;

import dlut.edu.text.common.result.HttpResult;
import dlut.edu.text.integration.mbg.model.SysRule;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.service.FileLocalStorageService;
import dlut.edu.text.service.service.SysRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/5/5 15:06
 */
@RestController
@RequestMapping("rule")
public class SysRuleController {
    @Autowired
    private SysRuleService sysRuleService;
    
    @Autowired
    private FileLocalStorageService fileLocalStorageService;
    
    @PreAuthorize("hasAuthority('sys:rule:add') AND hasAuthority('sys:rule:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysRule record) {
        if ((record.getId() == null || record.getId() == 0) && sysRuleService.selectByFileName(record.getFilename()) != null) {
            return HttpResult.error("该文件已存在!");
        }
        return HttpResult.ok(sysRuleService.save(record));
    }
    @PreAuthorize("hasAuthority('sys:rule:add')")
    @PostMapping(value = "/add")
    public HttpResult add(String code,@RequestParam("file") MultipartFile file){
        String filename = file.getOriginalFilename();
        if (sysRuleService.selectByFileName(filename).isPresent()) {
            return HttpResult.error("该文件已存在!");
        }
        Long areaCode = Long.parseLong(code);
        String filePath = fileLocalStorageService.fileStorageToBeRules(areaCode,file);
        SysRule record = new SysRule();
        record.setCode(areaCode);
        record.setDate(LocalDateTime.now());
        record.setFilename(filename);
        record.setFilepath(filePath);
        return HttpResult.ok(sysRuleService.save(record));
    }
    
    @PreAuthorize("hasAuthority('sys:rule:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysRule> records) {
        return HttpResult.ok(sysRuleService.delete(records));
    }
    
    @PreAuthorize("hasAuthority('sys:rule:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysRuleService.findPage(pageRequest));
    }
}
