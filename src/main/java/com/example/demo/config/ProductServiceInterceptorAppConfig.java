package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.ProductServiceInterceptor;

@Component
public class ProductServiceInterceptorAppConfig implements WebMvcConfigurer {

	@Autowired
	ProductServiceInterceptor productServiceInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(productServiceInterceptor);
	}
}
