package dlut.edu.text.web.controller;

import dlut.edu.text.common.consts.SysConstants;
import dlut.edu.text.common.result.HttpResult;
import dlut.edu.text.integration.mbg.model.SysUser;
import dlut.edu.text.service.page.PageRequest;
import dlut.edu.text.service.service.SysUserService;
import dlut.edu.text.web.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2022/1/2 17:43
 */
@RestController
@RequestMapping("user")
public class SysUserContrller {
    @Autowired
    private SysUserService sysUserService;

    @PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysUser record) {
        Optional<SysUser> optionalSysUser = sysUserService.findById(record.getId());
        if(optionalSysUser.isPresent()){
            SysUser user = optionalSysUser.get();
            if(SysConstants.ADMIN.equalsIgnoreCase(user.getName())){
                return HttpResult.error("超级管理员不允许修改");
            }
        }
        if(record.getPassword() !=null) {
            String salt = PasswordUtils.getSalt();
            if(!optionalSysUser.isPresent()){
                // 新增用户
                if(sysUserService.getUserByName(record.getName()).isPresent()){
                    return HttpResult.error("用户名已存在");
                }
                String password = PasswordUtils.encode(record.getPassword(),salt);
                record.setSalt(salt);
                record.setPassword(password);
            } else {
                // 修改用户，且修改了密码
                SysUser user = optionalSysUser.get();
                if(! record.getPassword().equals(user.getPassword())) {
                    String password = PasswordUtils.encode(record.getPassword(),salt);
                    record.setSalt(salt);
                    record.setPassword(password);
                }
            }
        }
        return HttpResult.ok(sysUserService.save(record));
    }
    
    @PreAuthorize("hasAuthority('sys:user:delete')")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysUser> records) {
        for(SysUser record:records) {
            SysUser sysUser = sysUserService.findById(record.getId()).get();
            if(sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
                return HttpResult.error("超级管理员不允许删除!");
            }
        }
        return HttpResult.ok(sysUserService.delete(records));
    }
    
    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findByName")
    public HttpResult findByUserName(@RequestParam String name) {
        return HttpResult.ok(sysUserService.getUserByName(name));
    }
    
    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        return HttpResult.ok(sysUserService.getPermissions(name));
    }
    
    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findUserRoles")
    public HttpResult findUserRoles(@RequestParam Long userId) {
        return HttpResult.ok(sysUserService.getUserRoles(userId));
    }
    
    @PreAuthorize("hasAuthority('sys:user:view')")
    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

}
