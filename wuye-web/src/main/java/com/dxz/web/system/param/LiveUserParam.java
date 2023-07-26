package com.dxz.web.system.param;

import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/33/26(星期三) 13:33
 * request：
 */

@Data
public class LiveUserParam extends BaseParam {
    //姓名
    private String trueName;
    //手机号
    private String phone;
}
