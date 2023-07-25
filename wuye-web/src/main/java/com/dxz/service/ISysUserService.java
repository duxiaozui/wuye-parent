package com.dxz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.entity.SysUser;
import com.dxz.param.SysUserParam;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
public interface ISysUserService extends IService<SysUser> {
    IPage<SysUser> list(SysUserParam sysUserParam);
}
