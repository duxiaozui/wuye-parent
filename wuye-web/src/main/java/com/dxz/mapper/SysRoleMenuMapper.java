package com.dxz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dxz.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单中间表 Mapper 接口
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    List<Integer> selectMenuIdsByRoleId(Integer roleId);
}
