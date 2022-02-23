package com.example.demo.config;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPattern;

@Configuration
public class FileHandleConfig implements WebMvcConfigurer {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/uploadfile/attachment/**").addResourceLocations("/home/HWSoftware/images/");
        registry.addResourceHandler("/uploadfile/attachment/**").addResourceLocations("file:/home/HWSoftware/images/");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/file/**").addResourceLocations("file:"+uploadPath);
//        super.addResourceHandlers(registry);
//    }
}
