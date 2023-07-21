package com.dxz.exception;

import com.dxz.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/22/21(星期五) 11:22
 * request：编写全局异常处理工具类
 */

@RestControllerAdvice("com.dxz")
@Slf4j
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e) {
        log.error("系统异常" + e.getMessage());
        return Result.error(500, e.getMessage());
    }
}
