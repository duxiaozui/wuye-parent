package com.dxz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/53/21(星期五) 10:53
 * request：
 */
@SpringBootApplication
public class WyApplication {
    public static void main(String[] args) {
        SpringApplication.run(WyApplication.class, args);
        //SpringApplication springApplication = new SpringApplication(WyApplication.class);
        //springApplication.setBannerMode(Banner.Mode.CONSOLE);
        //springApplication.run(args);
    }
}