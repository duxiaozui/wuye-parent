package com.dxz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dxz.entity.SysMenu;
import com.dxz.mapper.SysMenuMapper;
import com.dxz.service.ISysMenuService;
import com.dxz.utils.MakeMenuTree;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List getList() {
        //构造查询条件
        LambdaQueryWrapper<SysMenu> query = new LambdaQueryWrapper<>();
        query.orderByAsc(SysMenu::getOrderNum);
        List<SysMenu> menus = this.baseMapper.selectList(query);

        //封装成数形数据
        List<SysMenu> result = MakeMenuTree.makeTree(menus, 0);

        return result;
    }

    @Override
    public List<SysMenu> getParentList() {
        //只查询目录和菜单既只查询0和1的数据
        Integer[] types = {0, 1};
        //构造查询条件
        LambdaQueryWrapper<SysMenu> query = new LambdaQueryWrapper<>();
        query.in(SysMenu::getType, types).orderByAsc(SysMenu::getOrderNum);
        List<SysMenu> menus = this.baseMapper.selectList(query);

        //构造顶级菜单
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuId(0);
        sysMenu.setParentId(-1);
        sysMenu.setModuleLabel("顶级菜单");
        menus.add(sysMenu);

        //构造树形菜单
        List<SysMenu> result = MakeMenuTree.makeTree(menus, -1);
        return result;
    }
}
