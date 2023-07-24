package com.dxz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.entity.SysUser;
import com.dxz.service.ISysUserService;
import com.dxz.utils.Result;
import com.dxz.utils.SysUserParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户管理")
public class SysUserController {
    @Autowired
    private ISysUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation("新增用户")
    @PostMapping
    public Result addUser(@RequestBody SysUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        boolean save = userService.save(user);
        if (save) {
            return Result.success();
        }
        return Result.error(500, "新增失败");
    }

    @ApiOperation("编辑用户")
    @PutMapping
    public Result editUser(@RequestBody SysUser user) {
        boolean update = userService.updateById(user);
        if (update) {
            return Result.success();
        }
        return Result.error(500, "修改失败");
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{userId}")
    public Result deleteUser(@PathVariable("userId") Integer userId) {
        boolean remove = userService.removeById(userId);
        if (remove) {
            return Result.success();
        }
        return Result.error(500, "删除失败");
    }

    @ApiOperation("用户列表")
    @GetMapping("/list")
    public Result list(SysUserParam sysUserParam) {
        IPage<SysUser> page = userService.list(sysUserParam);
        return Result.success(page);
    }
}
