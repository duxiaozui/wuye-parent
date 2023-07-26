package com.dxz.web.house.param;

import com.dxz.web.system.param.BaseParam;
import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/08/26(星期三) 10:08
 * request：单元管理后台实现
 */

@Data
public class HouseUnitParam extends BaseParam {
    private String buildName;
    private String unitName;
}
