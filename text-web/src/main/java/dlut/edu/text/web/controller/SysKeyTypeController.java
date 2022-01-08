package dlut.edu.text.web.controller;

import dlut.edu.text.common.consts.SysConstants;
import dlut.edu.text.common.result.HttpResult;

import dlut.edu.text.integration.mbg.model.SysKeytype;
import dlut.edu.text.integration.mbg.model.SysKeyword;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.service.SysKeyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/5 13:38
 */
@RestController
@RequestMapping("keytype")
public class SysKeyTypeController {
    @Autowired
    private SysKeyTypeService sysKeyTypeService;
    
    @PreAuthorize("hasAuthority('sys:keyword:add') AND hasAuthority('sys:keyword:edit')")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysKeytype record) {
        // 新增角色
        if((record.getId() == null || record.getId() ==0) && !sysKeyTypeService.getByName(record.getValue()).isEmpty()) {
            return HttpResult.error("该类别已存在!");
        }
        return HttpResult.ok(sysKeyTypeService.save(record));
    }
    
    @PreAuthorize("hasAuthority('sys:keyword:delete')")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysKeytype> records) {
        return HttpResult.ok(sysKeyTypeService.delete(records));
    }
    
    @PreAuthorize("hasAuthority('sys:keyword:view')")
    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysKeyTypeService.findPage(pageRequest));
    }
    
    @PreAuthorize("hasAuthority('sys:keyword:view')")
    @GetMapping(value="/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysKeyTypeService.getAll());
    }
    
    @PreAuthorize("hasAuthority('sys:keyword:view')")
    @GetMapping(value="/findKeyWords")
    public HttpResult findKeyWords(@RequestParam Long keytypeId) {
        return HttpResult.ok(sysKeyTypeService.getKeyWords(keytypeId));
    }
    
    @PreAuthorize("hasAuthority('sys:keyword:view')")
    @PostMapping(value="/saveKeyWords")
    public HttpResult saveKeyWords(@RequestBody List<SysKeyword> records) {
        return HttpResult.ok(sysKeyTypeService.saveKeyWords(records));
    }
}
