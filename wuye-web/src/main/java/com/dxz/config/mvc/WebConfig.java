package com.dxz.config.mvc;

import com.dxz.config.security.JwtAuthenticationTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/20/21(星期五) 15:20
 * request：配置spring过滤器链不管理认证过滤器
 */

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>(jwtAuthenticationTokenFilter);
        filterFilterRegistrationBean.setEnabled(false);
        return filterFilterRegistrationBean;
    }
}