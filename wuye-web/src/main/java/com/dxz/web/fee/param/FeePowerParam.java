package com.dxz.web.fee.param;

import com.dxz.web.system.param.BaseParam;
import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/18/26(星期三) 15:18
 * request：
 */

@Data
public class FeePowerParam extends BaseParam {
    private String username;
    private String houseNum;
}