package com.dxz.web.repair.controller;

import com.dxz.utils.Result;
import com.dxz.web.repair.param.UserRepairParam;
import com.dxz.web.repair.po.UserRepair;
import com.dxz.web.repair.service.UserRepairService;
import com.dxz.web.system.entity.LiveUser;
import com.dxz.web.system.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/25/28(星期五) 17:25
 * request：
 */

@Api(tags = "业主报修")
@RequestMapping("/api/repair")
@RestController
public class UserRepairController {
    @Autowired
    private UserRepairService userRepairService;

    @ApiOperation("维修列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('wy:repair:list')")
    public Result getList(UserRepairParam param) {
        Map<String, Object> map = userRepairService.getList(param);
        return Result.success(map);
    }

    @ApiOperation("我的维修列表")
    @GetMapping("/myList")
    public Result myList(UserRepairParam param) {
        param.setUserId(getUserId());
        Map<String, Object> map = userRepairService.myList(param);
        return Result.success(map);
    }

    @ApiOperation("添加报修")
    @PostMapping
    public Result addRepair(@RequestBody UserRepair userRepair) {
        userRepair.setId(null);
        userRepair.setUserId(getUserId());
        userRepair.setCommitTime(LocalDateTime.now());
        userRepair.setStatus(0);
        userRepairService.addRepair(userRepair);

        return Result.success();
    }

    @ApiOperation("修改报修")
    @PutMapping
    public Result updateRepair(@RequestBody UserRepair userRepair) {
        userRepairService.updateRepair(userRepair);
        return Result.success();
    }

    @ApiOperation("删除报修")
    @DeleteMapping("/{id}")
    public Result deleteRepair(@PathVariable("id") String id) {
        userRepairService.deleteRepair(id);
        return Result.success();
    }

    private Integer getUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof SysUser) {
            SysUser sysUser = (SysUser) principal;
            return sysUser.getUserId();
        } else {
            LiveUser liveUser = (LiveUser) principal;
            return liveUser.getUserId();
        }
    }
}
