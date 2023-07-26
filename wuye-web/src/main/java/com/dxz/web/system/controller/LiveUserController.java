package com.dxz.web.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.utils.Result;
import com.dxz.web.system.entity.LiveUser;
import com.dxz.web.system.param.AssignHouseParam;
import com.dxz.web.system.param.LiveUserParam;
import com.dxz.web.system.service.ILiveUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 业主表 前端控制器
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
@RestController
@RequestMapping("/api/liveUser")
@Api(tags = "业主控制类")
public class LiveUserController {
    @Autowired
    private ILiveUserService liveUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation("业主列表")
    @GetMapping("/list")
    public Result getList(LiveUserParam param) {
        IPage<LiveUser> page = liveUserService.getList(param);
        return Result.success(page);
    }

    @ApiOperation("新增业主")
    @PostMapping
    public Result addLiveUser(@RequestBody LiveUser liveUser) {
        //查看用户名是否存在
        LambdaQueryWrapper<LiveUser> query = new LambdaQueryWrapper<>();
        query.eq(LiveUser::getUsername, liveUser.getUsername());
        LiveUser one = liveUserService.getOne(query);
        if (!Objects.isNull(one)) {
            return Result.error(500, "用户名已经存在");
        }
        //用户名加密
        liveUser.setPassword(passwordEncoder.encode(liveUser.getPassword()));
        //新增用户名
        liveUserService.saveLiveUser(liveUser);
        return Result.success();
    }

    @ApiOperation("编辑业主")
    @PutMapping
    public Result editLiveUser(@RequestBody LiveUser liveUser) {
        //查看用户名是否存在
        LambdaQueryWrapper<LiveUser> query = new LambdaQueryWrapper<>();
        query.eq(LiveUser::getUsername, liveUser.getUsername());
        LiveUser one = liveUserService.getOne(query);
        if (one != null && one.getUserId() != liveUser.getUserId()) {
            return Result.error(500, "用户名已存在");
        }
        //编辑用户
        liveUserService.editLiveUser(liveUser);
        return Result.success();
    }

    @ApiOperation("查看业主回显信息")
    @GetMapping("/getUserById/{userId}")
    public Result getUserById(@PathVariable("userId") Integer userId) {
        LiveUser user = liveUserService.getUser(userId);
        return Result.success(user);
    }

    @ApiOperation("分配房屋保存")
    @PostMapping("/assignHouse")
    public Result assignHouse(@RequestBody AssignHouseParam param) {
        liveUserService.assignHouse(param);
        return Result.success();
    }
}
