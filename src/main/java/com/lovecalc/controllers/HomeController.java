package com.lovecalc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lovecalc.api.CalculateLoveInfoDto;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(@ModelAttribute("loveDto") CalculateLoveInfoDto loveDto) {
		return "home-page";
	}
	
	@RequestMapping("/process-homepage")//once you create the object here, the values are set automatically by Spring
	public String processHome(@Valid @ModelAttribute("loveDto") CalculateLoveInfoDto loveDto, BindingResult result) {
		
		
		/*server side validation*/ 
		//if form has any errors
		if(result.hasErrors()) {
			
			//print out form was invalid in console
			System.out.println("form was invalid"); //will not work unless you have hibernate validator
			
			//print out and log all errors
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			
			//do not allow users to go to next page by returning current page
			return "home-page";
			
		}
		
		//validation for aggreement check
		if(loveDto.getAgreement() == false) {
			System.out.println("Error: user agreement unchecked");
			return "home-page"; 
		}
		
		//validation for number of failed attempts
		if(loveDto.getFailedTimes() < 0) {
			System.out.println("Error: user didn't put in a value large enough");
			return "home-page"; 
		}
		
		
		return "process-homepage";
	}
	
	
	/*long way of passing data to a vew
	@RequestMapping("/process-homepage")//once you create the object here, the values are set automatically by Spring
	public String processHome(CalculateLoveInfoDto loveDto, Model model) {
		//here we are writing the input data into the DTO object
		//add the object with auto-binded variables to the model
		model.addAttribute("loveDto", loveDto);
		return "process-homepage";
	}
	*/
}
