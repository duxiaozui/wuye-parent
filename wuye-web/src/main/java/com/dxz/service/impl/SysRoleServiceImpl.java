package com.dxz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxz.entity.SysRole;
import com.dxz.mapper.SysRoleMapper;
import com.dxz.service.ISysRoleService;
import com.dxz.utils.SysRoleParam;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
}
