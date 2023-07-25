package com.dxz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.entity.CheckMenuTreeVo;
import com.dxz.entity.SysMenu;
import com.dxz.param.SaveMenuIdsByRoleIdParam;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> getList();

    List<SysMenu> getParentList();

    CheckMenuTreeVo getAssignTree(Integer roleId);

    void saveMenuIdsByRoleId(SaveMenuIdsByRoleIdParam param);
}
