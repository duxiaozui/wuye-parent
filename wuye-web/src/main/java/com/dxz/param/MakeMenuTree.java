package com.dxz.param;

import com.dxz.entity.SysMenu;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/19/25(星期二) 9:19
 * request：编写树形菜单工具类--生成树工具
 */

public class MakeMenuTree {
    public static List<SysMenu> makeTree(List<SysMenu> menuList, Integer pid) {
        List<SysMenu> list = new ArrayList<>();
        Optional.ofNullable(menuList).orElse(new ArrayList<>())
                .stream()
                .filter(item -> item != null && item.getParentId() == pid)
                .forEach(dom -> {
                    SysMenu menu = new SysMenu();
                    BeanUtils.copyProperties(dom, menu);
                    List<SysMenu> menus = makeTree(menuList, dom.getMenuId());
                    menu.setChildren(menus);
                    list.add(menu);
                });
        return list;
    }
}
