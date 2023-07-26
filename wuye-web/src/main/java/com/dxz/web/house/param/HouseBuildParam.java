package com.dxz.web.house.param;

import com.dxz.web.system.param.BaseParam;
import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/50/25(星期二) 17:50
 * request：楼栋管理后台实现---楼栋列表查询参数
 */

@Data
public class HouseBuildParam extends BaseParam {
    private String buildName;
    private Integer type;
}
