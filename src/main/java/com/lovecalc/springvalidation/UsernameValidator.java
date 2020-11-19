package com.lovecalc.springvalidation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lovecalc.api.RegisterDto;

public class UsernameValidator implements Validator {

	//specifies the object for the validation logic
	//for Register DTO object since username belongs to that object
	@Override
	public boolean supports(Class<?> clazz) {	
		//determines if registerDto class is equal to clazz object
		return RegisterDto.class.equals(clazz); 
	}

	//write custom validation logic in this method
	@Override
	public void validate(Object target, Errors errors) {
		
		//check if field null, if null reject it
		//use validation utils class methods to reject
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "username.empty", "user name cannot be empty");
		
		//retrieve the value from the dto
		//only choice is to typecast since class is object, you can cast it to any class
		String username = ((RegisterDto)target).getUsername();
		
		//if value doesn't contain underscore, then reject it, and send error message
		if(!username.contains("_")) {
			errors.rejectValue("username", "username.underscore", "there is no underscore in the username");
		}
	}
}
