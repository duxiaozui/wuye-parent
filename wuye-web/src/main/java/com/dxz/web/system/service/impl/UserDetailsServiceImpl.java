package com.dxz.web.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dxz.utils.SystemConstant;
import com.dxz.web.system.entity.LiveUser;
import com.dxz.web.system.entity.SysMenu;
import com.dxz.web.system.entity.SysUser;
import com.dxz.web.system.mapper.LiveUserMapper;
import com.dxz.web.system.mapper.SysMenuMapper;
import com.dxz.web.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @Autowired
    private SysMenuMapper menuMapper;

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
            //查询物主权限
            Integer isAdmin = user.getIsAdmin();
            List<String> menus;
            if (isAdmin == 1) {
                //查询使用菜单
                List<SysMenu> menuList = menuMapper.selectList(null);
                menus = menuList.stream().map(SysMenu::getMenuCode).collect(Collectors.toList());
            } else {
                menus = sysUserMapper.getMenus(user.getUserId());
            }
            user.setMenus(menus.toArray(new String[menus.size()]));
            return user;
        } else if (userType == SystemConstant.USER_TYPE_YEZHU) {
            QueryWrapper<LiveUser> query = new QueryWrapper();
            query.lambda().eq(LiveUser::getUsername, username);
            LiveUser user = liveUserMapper.selectOne(query);
            if (Objects.isNull(user)) {
                throw new RuntimeException("用户名错误");
            }
            //查询业主权限
            List<String> menus = liveUserMapper.getMenus(user.getUserId());
            user.setMenus(menus.toArray(new String[menus.size()]));
            return user;
        } else {
            return null;
        }
    }
}