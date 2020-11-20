package com.lovecalc.springvalidation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lovecalc.api.RegisterDto;
import com.lovecalc.operator.*;

@Component
public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return RegisterDto.class.equals(clazz); //register outter most element
	}

	//Note: error code is the key for the message in the .properties file
	//field must access variableName.variable if object nested
	//Note: make sure error messages are pasted into .properties file with key as errorCode
	//e.g. email.empty = email cannot be empty
	@Override
	public void validate(Object target, Errors errors) {
		
		
		//get string from email in register dto
		String email = ((RegisterDto)target).getCommDto().getEmail(); //get nested object and property
		
		System.out.println("email in validator: " + email);
		
		//reject if email empty or white space
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commDto.email", 
				"email.empty", "email cannot be empty");
		
		//reject if email doesn't contain these domains send error
		String[] domains = {"@gmail.com", "@yahoo.com", "@comcast.net"};
		if(!StringOperator.contains(email, domains)){
			errors.rejectValue("commDto.email", "email.uncommon", 
					"email requires gmail yahoo or comcast");
		};
		
	}
}
