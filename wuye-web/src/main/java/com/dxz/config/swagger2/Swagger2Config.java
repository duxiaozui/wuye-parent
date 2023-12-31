package com.dxz.config.swagger2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/08/21(星期五) 11:08
 * request：配置Swagger2配置类
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean//设置接口框架的基本信息
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //接口描述信息
                .apiInfo(apiInfo())
                .select()
                //扫描哪些包创建接口文档
                .apis(RequestHandlerSelectors.basePackage("com.dxz"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("物业系统接口文档")
                .contact(new Contact("嘟小嘴", "http://127.0.0.1:8888/doc.html", "xxx@xx.com"))
                .version("3.1")
                .build();
    }
}