package com.dxz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.entity.SysRole;
import com.dxz.utils.SysRoleParam;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
public interface ISysRoleService extends IService<SysRole> {

    IPage<SysRole> list(SysRoleParam sysRoleParam);

    List<SysRole> checkRoles(Integer userId);
}
