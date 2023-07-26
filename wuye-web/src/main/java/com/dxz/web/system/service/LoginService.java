package com.dxz.web.system.service;

import com.dxz.utils.Result;
import com.dxz.web.system.param.BaseParam;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/15/21(星期五) 15:15
 * request：
 */
public interface LoginService {
    Result login(BaseParam.LoginParam loginParam);

    Result logout();
}
