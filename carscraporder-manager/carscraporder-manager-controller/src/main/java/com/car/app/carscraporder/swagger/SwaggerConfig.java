package com.car.app.carscraporder.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()                                  
                .apis(RequestHandlerSelectors.basePackage("com.car.app.carscraporder.controller"))//扫描com路径下的api文档
                .paths(PathSelectors.any())//路径判断
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger ")//标题
                .description("Saggger --->>>>>>>：")//描述
                .termsOfServiceUrl("http://blog.csdn.net/xxoo00xx00/article/details/77163399")//（不可见）条款地址
                .version("6.6.6")//版本号
                .build();
    }

}
