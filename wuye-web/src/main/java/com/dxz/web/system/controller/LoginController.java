package com.dxz.web.system.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.UUID;
import com.dxz.utils.RedisConstant;
import com.dxz.utils.Result;
import com.dxz.web.system.entity.LiveUser;
import com.dxz.web.system.entity.SysUser;
import com.dxz.web.system.param.BaseParam;
import com.dxz.web.system.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/44/21(星期五) 14:44
 * request：根据接口文档编写验证码接口
 */

@RestController
@RequestMapping("/api/")
@Api(tags = "登录处理类")
public class LoginController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private LoginService loginService;

    @PostMapping("/captcha")
    @ApiOperation("获取验证码")
    public Result<Map<String, String>> captcha() {
        //获取验证码
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 40, 4, 11);
        //获取验证码内容
        String captchaCode = lineCaptcha.getCode();
        //获取验证码图片压缩内容
        String imageBase64 = lineCaptcha.getImageBase64();
        //随机验证码id,用于存入redis中的key，方便后期查找
        String captchaId = UUID.randomUUID().toString(true);
        //将验证码存入redis中
        //key+id,value（内容），时间，时间单位===》redis
        redisTemplate.opsForValue().set(
                RedisConstant.CAPTCHA_PRE + captchaId,
                captchaCode,
                RedisConstant.CAPTCHA_EXPIRE_TIME,
                TimeUnit.SECONDS);
        //将验证码图片和id响应给客户端
        Map<String, String> map = new HashMap<>();
        map.put("captchaId", captchaId);
        map.put("imageBase64", imageBase64);
        return Result.success(map);
    }

    @PostMapping("/login")
    @ApiOperation("登录处理")
    public Result login(
            @RequestBody
            @Valid//用于启用Bean验证
            @ApiParam(value = "登录需要参数", required = true)
            BaseParam.LoginParam loginParam) {
        return loginService.login(loginParam);
    }

    @GetMapping("/hello")
    public Result hello() {
        return Result.success("hello");
    }

    @PostMapping("/logout")
    @ApiOperation("安全退出")
    public Result logout() {
        return loginService.logout();
    }

    @GetMapping("/getInfo")
    @ApiOperation("查看个人信息")
    public Result getInfo() {
        //获取上下文的身份验证:用于获取当前用户的认证信息（Authentication）的常用方法
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取身份信息:用于获取认证对象中的主体（Principal）信息
        Object principal = authentication.getPrincipal();
        if (principal instanceof SysUser) {
            SysUser sysUser = (SysUser) principal;
            return Result.success(sysUser);
        } else {
            LiveUser liveUser = (LiveUser) principal;
            return Result.success(liveUser);
        }

    }
}
