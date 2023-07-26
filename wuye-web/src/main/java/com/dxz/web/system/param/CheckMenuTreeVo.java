package com.dxz.web.system.param;

import com.dxz.web.system.entity.SysMenu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/24/25(星期二) 16:24
 * request：
 */

@Data
public class CheckMenuTreeVo {
    //权限菜单树
    private List<SysMenu> tree = new ArrayList<>();
    //原来分配的菜单id
    private List<Integer> checkMenuIds;
}