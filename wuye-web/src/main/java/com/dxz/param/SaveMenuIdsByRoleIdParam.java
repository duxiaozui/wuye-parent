package com.dxz.param;

import lombok.Data;

import java.util.List;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/24/25(星期二) 16:24
 * request：
 */

@Data
public class SaveMenuIdsByRoleIdParam {
    private Integer roleId;
    private List<Integer> menuIds;
}