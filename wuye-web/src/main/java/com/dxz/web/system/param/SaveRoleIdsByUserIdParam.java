package com.dxz.web.system.param;

import lombok.Data;

import java.util.List;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/20/25(星期二) 15:20
 * request：角色信息方法
 */

@Data
public class SaveRoleIdsByUserIdParam {
    private Integer userId;
    private List<Integer> roleIds;
}