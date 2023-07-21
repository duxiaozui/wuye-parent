package com.dxz.service;

import com.dxz.entity.LoginParam;
import com.dxz.utils.Result;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/15/21(星期五) 15:15
 * request：
 */
public interface LoginService {
    Result login(LoginParam loginParam);

    Result logout();
}
