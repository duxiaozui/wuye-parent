package com.dxz.web.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxz.web.system.entity.SysUser;
import com.dxz.web.system.mapper.SysUserMapper;
import com.dxz.web.system.param.SysUserParam;
import com.dxz.web.system.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public IPage<SysUser> list(SysUserParam sysUserParam) {
//构建分页对象
        IPage<SysUser> page = new Page(sysUserParam.getCurrentPage(), sysUserParam.getPageSize());
        //构建查询条件
        LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<>();
        String trueName = sysUserParam.getTrueName();
        String phone = sysUserParam.getPhone();
        if (StringUtils.hasText(trueName)) {
            query.like(SysUser::getTrueName, trueName);
        }
        if (StringUtils.hasText(phone)) {
            query.like(SysUser::getPhone, phone);
        }
        return this.baseMapper.selectPage(page, query);
    }
}
