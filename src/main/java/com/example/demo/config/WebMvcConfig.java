package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义静态资源访问，这是第一种方式，第二种方式是通过   配置文件
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有D:\\springboot\\pic\\ 访问都映射到/myPic/** 路径下
       // registry.addResourceHandler("/myPic/**").addResourceLocations("file:D:/pic/");

        //配置映射关系
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
                .resourceChain(true);
        //加入resourceChain属性，不然还是去除了版本时路径找不到的
    }
}
