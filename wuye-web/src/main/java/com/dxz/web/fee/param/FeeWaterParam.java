package com.dxz.web.fee.param;

import com.dxz.web.system.param.BaseParam;
import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/00/26(星期三) 16:00
 * request：水费
 */

@Data
public class FeeWaterParam extends BaseParam {
    private String username;
    private String houseNum;
}
