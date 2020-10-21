package com.swagger.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 *@description:
 *@author: klw
 *@time: 2020-10-14 11:33
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public  Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Docket1");
    }
    @Bean
    public  Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Docket2");
    }
    @Bean
    public  Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Docket3");
    }
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("klw1")
                .select()
                //指定扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.swagger.swagger.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        Contact DEFAULT_CONTACT = new Contact("klw", "https://github.com/kangliuwen", "1094127610@qq.com");
        return new ApiInfo(
                "Swagger 面板",
                "远航的鸡",
                "v1.0",
                "https://github.com/kangliuwen",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
