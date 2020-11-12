package com.lovecalc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalc.api.CommunicationDto;
import com.lovecalc.api.Phone;
import com.lovecalc.api.RegisterDto;

@Controller
public class RegistrationController {
	
	//the Dto object acts as both sending info to the view, 
	//and getting info from the view to save in the database
	@RequestMapping("/register")
	public String registrationForm(@ModelAttribute("RegisterDto") RegisterDto registerDto) {
		
		//retrieve data from the database and display to user 
		Phone phone = new Phone(); 
		phone.setCountryCode("55");
		phone.setUserNumber("11223344"); //pretend this data came from the database
		
		
		//set some random variables for the registerDto to display in the view, 
		//pretend these came from a database
		String[] hobbies = {"sports", "eating", "reading"}; 
		char[] password = {'m', 'y','p','a','s','w','o','r','d'};
		registerDto.setAge(500);
		registerDto.setGender("female");
		registerDto.setName("Steve-a-rino");
		registerDto.setHobbies(hobbies);
		registerDto.setUsername("ThisSoFrustrating");
		registerDto.setPassword(password);
		

		//set the retrieved phone info into the dto associated with this page
		CommunicationDto commDto = new CommunicationDto();
		commDto.setEmail("fantastic@gmail.com");
		commDto.setPhone(phone);
		registerDto.setCommDto(commDto);
		
		
		//the formatter is called here and needs to convert the phone object into string
		
		
		return "register-form";
	}
	
	
	@RequestMapping("/register-process")
	public String processRegister(@Valid @ModelAttribute("RegisterDto") RegisterDto registerDto, BindingResult result) {
		
		if(result.hasErrors()) {
			
			//capture all errors
			List<ObjectError> errorList = result.getAllErrors();
			
			
			//print all errors
			for(ObjectError error : errorList) {
				System.out.println(error);
			}
			
			
			return "register-form";
		}
		
		//save the data to database when user hits submits register dto
		return "register-process";
		
	}
	

}
