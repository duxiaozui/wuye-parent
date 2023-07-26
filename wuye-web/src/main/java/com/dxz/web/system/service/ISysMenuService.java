package com.dxz.web.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dxz.web.system.entity.SysMenu;
import com.dxz.web.system.param.CheckMenuTreeVo;
import com.dxz.web.system.param.SaveMenuIdsByRoleIdParam;

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
