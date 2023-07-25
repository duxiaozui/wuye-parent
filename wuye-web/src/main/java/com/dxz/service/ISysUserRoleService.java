package com.dxz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.entity.SysUserRole;
import com.dxz.utils.SaveRoleIdsByUserIdParam;

/**
 * <p>
 * 用户角色中间表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    boolean saveRoleIdsByUserId(SaveRoleIdsByUserIdParam param);


}
