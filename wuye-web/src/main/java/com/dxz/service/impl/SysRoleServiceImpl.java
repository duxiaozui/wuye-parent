package com.dxz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxz.entity.SysRole;
import com.dxz.mapper.SysRoleMapper;
import com.dxz.mapper.SysUserRoleMapper;
import com.dxz.service.ISysRoleService;
import com.dxz.utils.SysRoleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Override
    public IPage<SysRole> list(SysRoleParam sysRoleParam) {
        //构建分页对象
        IPage<SysRole> page = new Page<>(sysRoleParam.getCurrentPage(), sysRoleParam.getPageSize());
        //构建查询条件
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper();
        if (StringUtils.hasText(sysRoleParam.getRoleName())) {
            queryWrapper.like(SysRole::getRoleName, sysRoleParam.getRoleName());
        }
        return this.baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<SysRole> checkRoles(Integer userId) {
        //查询所有角色信息
        List<SysRole> roles = this.baseMapper.selectList(null);
        //查询用户拥有的角色信息id
        List<Integer> sysUserRoles = userRoleMapper.selectRoleIds(userId);
        List<SysRole> result = roles.stream().map(role -> {
            if (sysUserRoles.contains(role.getRoleId())) {
                role.setChecked(true);
            }
            return role;
        }).collect(Collectors.toList());
        return result;
    }
}
