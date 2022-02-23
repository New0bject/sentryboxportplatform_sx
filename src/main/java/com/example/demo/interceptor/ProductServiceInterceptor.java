package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
* <p>Title: ProductServiceInterceptor</p>  
* <p>Description: 拦截器实现类</p>  
* @author shenlan  
* @date 2019年10月22日
 */
@Component
public class ProductServiceInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		System.out.println("用于在将请求发送到控制器之前执行操作");
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("用于在将响应发送到客户端之前执行操作");
		
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("用于在完成请求和响应后执行操作");
		
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
