package com.dxz.web.house.param;

import com.dxz.web.system.param.BaseParam;
import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/19/26(星期三) 10:19
 * request：
 */


@Data
public class HouseListParam extends BaseParam {
    //楼栋名称
    private String buildName;
    //使用状态
    private Integer status;
    //单元名称
    private String unitName;
    //房屋编号
    private String houseNum;
}