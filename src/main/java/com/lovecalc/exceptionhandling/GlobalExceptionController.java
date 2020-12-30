package com.lovecalc.exceptionhandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//this class allows for a handler methods to handle exceptions, but for ALL controllers rather then one

@ControllerAdvice //allows the exception handler method to work for all other controllers
public class GlobalExceptionController {
	
	@ExceptionHandler(value=Exception.class)
	public String handleAllExceptions() {
		return "nullpointerexception"; //can replace the page with a new one if necessary
	}

}
