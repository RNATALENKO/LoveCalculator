package com.lovecalc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalc.api.EmailDto;
import com.lovecalc.springvalidation.EmailResultsValidator;


/*
 * Notes on validation: 
 * 
 * @valid is required for the model, to activate validation, including the binding results
 * 
 */


@Controller
public class EmailController {
	
	@RequestMapping("/sendemail")
	public String emailPage(@ModelAttribute("emailDto") EmailDto emailDto) {
		
		return "email-page";
	}
	
	@RequestMapping("/emailconfirmation")
	public String processEmail(@Valid @ModelAttribute("emailDto") EmailDto emailDto, BindingResult results) {
		
		
		//need validation that email was sent successfully
		
		List<ObjectError> errorList =  results.getAllErrors();
		
		if(results.hasErrors()) {
			
			//print the errors
			for(ObjectError errors: errorList) {
				System.out.println(errors);
			}
			return "email-page";
		}
		
		return "email-process";
		
	}
	
	
	//init binder to validate email address
	@InitBinder
	public void binder(WebDataBinder binder) {
			//add the email validator
			binder.addValidators(new EmailResultsValidator());
	}

}