package com.dxz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.entity.SysRole;
import com.dxz.service.ISysRoleService;
import com.dxz.utils.Result;
import com.dxz.utils.SysRoleParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
@RestController
@RequestMapping("/api/role")
@Api(tags = "角色管理")
public class SysRoleController {
    @Autowired
    private ISysRoleService roleService;

    @ApiOperation("角色列表")
    @GetMapping("/list")
    public Result list(SysRoleParam sysRoleParam) {
        IPage<SysRole> page = roleService.list(sysRoleParam);
        return Result.success(page);
    }

    @ApiOperation("添加角色")
    @PostMapping
    public Result addRole(@RequestBody SysRole sysRole) {
        boolean save = roleService.save(sysRole);
        if (save) {
            return Result.success();
        }
        return Result.error(500, "添加失败");
    }

    @ApiOperation("修改角色")
    @PutMapping
    public Result editRole(@RequestBody SysRole sysRole) {
        boolean update = roleService.updateById(sysRole);
        if (update) {
            return Result.success();
        }
        return Result.error(500, "修改失败");
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{roleId}")
    public Result deleteRole(@PathVariable("roleId") Integer roleId) {
        boolean deleted = roleService.removeById(roleId);
        if (deleted) {
            return Result.success();
        }
        return Result.error(500, "删除失败");
    }
}
