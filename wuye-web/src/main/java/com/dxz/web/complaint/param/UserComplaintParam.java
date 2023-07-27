package com.dxz.web.complaint.param;

import com.dxz.web.system.param.BaseParam;
import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/24/27(星期四) 10:24
 * request：
 */

@Data
public class UserComplaintParam extends BaseParam {
    //投诉人
    private Integer userId;
    //标题
    private String title;
    //内容
    private String content;
}