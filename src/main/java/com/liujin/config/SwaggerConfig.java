package com.liujin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket(Environment environment) {
        //生产环境和正式环境，正式环境不可以显示
        //设置环境为正式环境
        Profiles profiles = Profiles.of("dev");
        //判断当前环境是否处于自己设置的环境当中
        boolean flag = environment.acceptsProfiles(profiles);



        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        //作者信息
        Contact contact = new Contact("liujin", "https://liu.com", "1532551496@qq.com");

        //Swagger配置信息
        ApiInfo apiInfo = new ApiInfo("开发者文档",
                "前后端分离",
                "v1.0",
                "http://bigshop.com", contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
        docket.apiInfo(apiInfo)
                .enable(flag)//如果值为false，则不能在浏览器中访问swagger，默认为true
                .select()
                .apis(RequestHandlerSelectors
                //RequestHandlerSelectors;配置要扫描接口的方式
                //basePackage;指定要扫描的包（一般使用的都是这个）
                //any();扫描全部
                //none();不扫描
                //withClassAnnotation:扫描的是类上的注解
                //withMethodAnotation;扫描的是方法上的注解

                .basePackage("com.liujin.controller"))
                //paths（）过滤什么路径，比如在上面controller包下继续过滤带。。。。的接口
                //一般使用的是ant方法
                .paths(PathSelectors.ant("/liu/**"))
                .build();
        return docket;

    }
}
