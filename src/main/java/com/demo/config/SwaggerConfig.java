package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
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
 * create by liu_zhang on 2019/10/22 16:31.
 */
@Configuration
@EnableSwagger2
@ComponentScan(value = "com.demo.controller")
public class SwaggerConfig {

    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    public ApiInfo apiInfo(){

        Contact contact = new Contact("test1", "localhost","lz92225@163.com");

        return new ApiInfoBuilder()
                .title("测试swagger")
                .description("测试")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
