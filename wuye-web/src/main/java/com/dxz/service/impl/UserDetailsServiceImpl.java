package com.dxz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dxz.entity.LiveUser;
import com.dxz.entity.SysUser;
import com.dxz.mapper.LiveUserMapper;
import com.dxz.mapper.SysUserMapper;
import com.dxz.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/07/21(星期五) 15:07
 * request：编写UserDetialsServiceImpl ，查询用户信息
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private LiveUserMapper liveUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //接收到到username是 admin:1 1代表物主身份，0代表业主身份获取用户身份
        Integer userType = Integer.parseInt(username.substring(username.indexOf(":") + 1));
        //获取用户名
        username = username.substring(0, username.indexOf(":"));
        //物主身份查询
        if (userType == SystemConstant.USER_TYPE_WUZHU) {
            QueryWrapper<SysUser> query = new QueryWrapper();
            query.lambda().eq(SysUser::getUsername, username);
            SysUser user = sysUserMapper.selectOne(query);
            if (Objects.isNull(user)) {
                throw new RuntimeException("用户名错误");
            }
            return user;
        } else if (userType == SystemConstant.USER_TYPE_YEZHU) {
            QueryWrapper<LiveUser> query = new QueryWrapper();
            query.lambda().eq(LiveUser::getUsername, username);
            LiveUser user = liveUserMapper.selectOne(query);
            if (Objects.isNull(user)) {
                throw new RuntimeException("用户名错误");
            }
            return user;
        } else {
            return null;
        }
    }
}