package com.dxz.param;

import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/40/24(星期一) 19:40
 * request：用户管理后台
 */

@Data
public class SysUserParam extends BaseParam {
    private String trueName;
    private String phone;
}
