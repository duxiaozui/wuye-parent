package com.dxz.param;

import lombok.Data;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/14/21(星期五) 11:14
 * request：编写接收分页请求参数类
 */

@Data
public class BaseParam {
    private Integer currentPage = 1;//当前页
    private Integer pageSize = 5;//每页参数展示大小
}
