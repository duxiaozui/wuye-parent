package com.dxz.config.security;

import cn.hutool.json.JSONUtil;
import com.dxz.utils.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/26/01(星期二) 14:26
 * request：编写权限不足处理器
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result result = Result.permissionDenied();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSONUtil.toJsonStr(result));
    }
}