package com.dxz.web.repair.param;

import com.dxz.web.system.param.BaseParam;
import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/23/28(星期五) 17:23
 * request：编写请求参数
 */

@Data
public class UserRepairParam extends BaseParam {
    //报修人
    private Integer userId;
    //维修内容
    private String content;
}