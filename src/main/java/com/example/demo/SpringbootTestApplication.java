package com.example.demo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.demo.util.WebSocket;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 
* <p>Title: SpringbootTestApplication</p>  
* <p>Description: SpringBoot 入口类</p>  
* @author shenlan  
* @date 2019年10月22日
 */
@MapperScan("com.example.demo.mapper")
@SpringBootApplication
@ServletComponentScan
@EnableCaching
public class SpringbootTestApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootTestApplication.class);
    }
	
	public static void main(String[] args) {
//		SpringApplication.run(SpringbootTestApplication.class, args);
		SpringApplication springApplication = new SpringApplication(SpringbootTestApplication.class);
		ConfigurableApplicationContext run = springApplication.run(args);
        //注入application
		WebSocket.setApplicationContext(run);
	}
	
	@PostConstruct
	void setDefaultTimezone(){
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		WebSocket.setApplicationContext(WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext));
	}
}
