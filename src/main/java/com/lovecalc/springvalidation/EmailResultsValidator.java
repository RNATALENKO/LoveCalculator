package com.lovecalc.springvalidation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lovecalc.api.EmailDto;

@Component //don't forget to register the validation as a bean in Spring, otherwise it won't register
public class EmailResultsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return EmailDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		
		//get the email string from email Dto
		String email = ((EmailDto)target).getEmail();
		
		//write logic here
		
		//1. apply if whitespace or empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
		
		//2. if the email is improperty formatted
		String regexPattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		
		if(!email.matches(regexPattern)) {
			errors.rejectValue("email", "email.invalid");
		}
		
		
	
	}

}
