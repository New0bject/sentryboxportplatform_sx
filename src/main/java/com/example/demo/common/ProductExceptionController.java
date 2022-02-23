package com.example.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.ProductNotfoundException;

/**
 * 
* <p>Title: ProductExceptionController</p>  
* <p>Description:统一异常处理类 </p>  
* @author shenlan  
* @date 2019年10月22日
 */
@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = ProductNotfoundException.class)
	public ResponseEntity<Object> notfoundException(ProductNotfoundException notfoundException){
		return new ResponseEntity<Object>("找不到",HttpStatus.NOT_FOUND);
	}
}
