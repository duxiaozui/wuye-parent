package com.dxz.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/12/21(星期五) 11:12
 * request：编写跨域工具类
 */

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        //接受任意域名的请求
        config.addAllowedOrigin("*");
        //不支持提交COOKIE数据
        config.setAllowCredentials(false);
        //绑定请求头信息，使用通配符*接受任意字段
        config.addAllowedHeader("*");
        //支持任意提交方法
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }

}