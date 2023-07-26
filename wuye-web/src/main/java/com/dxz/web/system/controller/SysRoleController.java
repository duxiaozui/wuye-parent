package com.dxz.web.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.utils.Result;
import com.dxz.web.system.entity.SysRole;
import com.dxz.web.system.param.CheckMenuTreeVo;
import com.dxz.web.system.param.SaveMenuIdsByRoleIdParam;
import com.dxz.web.system.param.SysRoleParam;
import com.dxz.web.system.service.ISysMenuService;
import com.dxz.web.system.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private ISysMenuService menuService;

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

    /**
     * 编写获得分配权限菜单、和保存角色拥有的权限
     */
    @ApiOperation("获得分配权限菜单")
    @GetMapping("/getAssignTree/{roleId}")
    public Result getAssignTree(@PathVariable("roleId") Integer roleId) {
        CheckMenuTreeVo checkMenuTreeVo = menuService.getAssignTree(roleId);
        return Result.success(checkMenuTreeVo);
    }

    @ApiOperation("保存角色拥有的权限信息")
    @PutMapping("/saveMenuIdsByRoleId")
    public Result saveMenuIdsByRoleId(@RequestBody SaveMenuIdsByRoleIdParam param) {
        menuService.saveMenuIdsByRoleId(param);
        return Result.success();
    }

    /**
     * @return 补充查询所有角色代码
     */
    @ApiOperation("获取所有角色列表")
    @GetMapping("/getList")
    public Result getList() {
        List<SysRole> list = roleService.list();
        return Result.success(list);
    }
}
