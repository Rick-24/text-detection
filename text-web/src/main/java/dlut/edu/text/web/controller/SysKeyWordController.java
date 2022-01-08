package dlut.edu.text.web.controller;

import dlut.edu.text.common.result.HttpResult;
import dlut.edu.text.integration.mbg.model.SysKeytype;
import dlut.edu.text.integration.mbg.model.SysKeyword;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.service.SysKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/5 16:04
 */
@RestController
@RequestMapping("keyword")
public class SysKeyWordController {
    
    @Autowired
    private SysKeywordService sysKeywordService;
    
    @PreAuthorize("hasAuthority('sys:keyword:add') AND hasAuthority('sys:keyword:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysKeyword record) {
        // 新增角色
        if ((record.getId() == null || record.getId() == 0) && sysKeywordService.getByValue(record.getValue()) != null) {
            return HttpResult.error("该类别已存在!");
        }
        return HttpResult.ok(sysKeywordService.save(record));
    }
    
    @PreAuthorize("hasAuthority('sys:keyword:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysKeyword> records) {
        return HttpResult.ok(sysKeywordService.delete(records));
    }
    
    @PreAuthorize("hasAuthority('sys:keyword:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysKeywordService.findPage(pageRequest));
    }
    
    @PreAuthorize("hasAuthority('sys:keyword:view')")
    @GetMapping(value = "/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysKeywordService.getAll());
    }
}
