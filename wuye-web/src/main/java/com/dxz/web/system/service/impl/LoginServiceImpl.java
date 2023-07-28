package com.dxz.web.system.service.impl;

import com.dxz.utils.JwtUtils;
import com.dxz.utils.RedisConstant;
import com.dxz.utils.Result;
import com.dxz.utils.SystemConstant;
import com.dxz.web.system.entity.LiveUser;
import com.dxz.web.system.entity.SysUser;
import com.dxz.web.system.param.BaseParam;
import com.dxz.web.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/15/21(星期五) 15:15
 * request：
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public Result login(BaseParam.LoginParam loginParam) {
        //调用构造方法validCaptcha---校验验证码是否正确
        validCaptcha(loginParam.getCaptchaId(), loginParam.getCaptchaCode());
        //调用构造方法validUsernameAndPassword---校验用户名密码是否正确
        Authentication authentication = validUsernameAndPassword(loginParam.getUsername(), loginParam.getUserType(), loginParam.getPassword());
        //将用户信息存入redis,并响应token数据
        return responseToken(loginParam.getUserType(), authentication);
    }

    @Override
    public Result logout() {
        //进行身份认证:用于获取当前用户的认证信息（Authentication）的常用方法。
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //用于获取认证对象中的主体（Principal）信息
        Object principal = authentication.getPrincipal();
        if (principal instanceof LiveUser) {
            LiveUser liveUser = (LiveUser) principal;
            //从Redis数据库中删除一个键:该键的名称由RedisConstant.LOGIN_LIVE_USER_PRE和liveUser.getUserId()拼接而成
            redisTemplate.delete(RedisConstant.LOGIN_LIVE_USER_PRE + liveUser.getUserId());
        } else if (principal instanceof SysUser) {
            SysUser sysUser = (SysUser) principal;
            redisTemplate.delete(RedisConstant.LOGIN_SYSTEM_USER_PRE + sysUser.getUserId());
        }
        return Result.success();
    }

    //响应token
    private Result responseToken(Integer userType, Authentication authentication) {
        int userId;
        String username;
        //如果登录的用户是业主，那么就将业主信息存入redis中，并响应token数据
        if (userType == SystemConstant.USER_TYPE_YEZHU) {
            //获取业主信息
            LiveUser liveUser = (LiveUser) authentication.getPrincipal();
            userId = liveUser.getUserId();
            username = liveUser.getUsername();
            //将用业主息存入redis中
            redisTemplate.opsForValue().set(
                    RedisConstant.LOGIN_LIVE_USER_PRE + userId,
                    liveUser,
                    RedisConstant.LOGIN_LIVE_USER_EXPIRE_TIME,
                    TimeUnit.MINUTES);
        } else {
            //获得用户信息
            SysUser sysUser = (SysUser) authentication.getPrincipal();
            userId = sysUser.getUserId();
            username = sysUser.getUsername();
            //将用户信息存入redis中
            redisTemplate.opsForValue().set(
                    RedisConstant.LOGIN_SYSTEM_USER_PRE + userId,
                    sysUser,
                    RedisConstant.LOGIN_SYSTEM_USER_EXPIRE_TIME,
                    TimeUnit.MINUTES);
        }
        //把token相应给前端
        String token = jwtUtils.generateToken(userId, username, userType);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return Result.success(map);
    }

    //校验验证码
    private void validCaptcha(String captchaId, String captchaCode) {
        //获取redis中存取的验证码内容
        //opsForValue（）方法获取值
        String captchaCode2 = (String) redisTemplate.opsForValue().get(RedisConstant.CAPTCHA_PRE + captchaId);
        if (!captchaCode.equalsIgnoreCase(captchaCode2)) {
            throw new RuntimeException("验证码错误");
        }
    }

    //校验用户名和密码
    private Authentication validUsernameAndPassword(String username, Integer userType, String password) {
        username = username + ":" + userType;
        //将用户名和密码封装成token
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        //进行认证
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("用户名或密码错误");
        }
        return authentication;
    }
}