package com.king.common.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //必须存在
@EnableSwagger2 //必须存在
@EnableWebMvc //必须存在
@ComponentScan(basePackages = {"com.king"})//必须存在
//配置SWAGGER需要扫描的接口包
public class SwaggerConfig{
	
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).enable(true).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        //Contact contact = new Contact("付为地", "", "1335157415@qq.com");
        return new ApiInfoBuilder()
                .title("API接口")
                .description("提供详细的后台所有Restful接口")
                //.contact(contact)
                .version("1.1.0")
                .build();
    }
   
}