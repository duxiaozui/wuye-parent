package com.dxz.web.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dxz.web.system.entity.SysUserRole;

import java.util.List;

/**
 * <p>
 * 用户角色中间表 Mapper 接口
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    List<Integer> selectRoleIds(Integer userId);
}
