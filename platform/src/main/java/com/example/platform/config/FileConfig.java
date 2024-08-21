package com.example.platform.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class FileConfig {

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("E:\\Workspaces\\IntellijIDEA\\platform4\\platform\\src\\main\\resources\\static");
        return factory.createMultipartConfig();
    }
}//E:\Workspaces\IntellijIDEA\platform4\platform\src\main\resources\static