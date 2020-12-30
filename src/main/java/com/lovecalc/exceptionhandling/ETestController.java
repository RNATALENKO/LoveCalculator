package com.lovecalc.exceptionhandling;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


//controller that will throw exception if for example we have a dependency which points to null http 500 error
//how to display a message instead of the server crashing

@Controller
public class ETestController {
	
	//null
	ServerInfo serverInfo; 
	
	
	@RequestMapping("/serverinfo")
	public String showPage(Model model) {
		
		
		//accessing serverInfo which is null because @Component and @Autowired missing
		//will cause app to throw nullpointerexception here
		model.addAttribute("serverinfo", serverInfo.getIp());
		
		
		return "server-info";
	}
	
	//method that will handle null pointer exception
	//this annotation means, anytime anywhere in the controller there is a nullpointer exception, we return this page
	//and this handler runs
	//these exceptions only handle ones that get thrown within this class
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNull() {
		return "nullpointerexception";
	}
	
	@ExceptionHandler(value=IOException.class)
	public String handleIO() {
		return "nullpointerexception"; //can replace the page with a new one if necessary
	}
	
	//generic method to handle all exceptions, only called if IO and NullPointer don't exist
	@ExceptionHandler(value=Exception.class)
	public String handleAllExceptions() {
		return "nullpointerexception"; //can replace the page with a new one if necessary
	}

}
