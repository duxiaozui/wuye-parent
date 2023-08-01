package com.dxz.config.security;

import cn.hutool.json.JSONUtil;
import com.dxz.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/27/21(星期五) 16:27
 * request：编写认证异常处理器
 */

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        Result result = Result.unauthorized();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSONUtil.toJsonStr(result));
    }
}