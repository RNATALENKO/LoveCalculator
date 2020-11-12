package com.lovecalc.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AgeConstraint implements ConstraintValidator<Age, Integer> {
	
	
	int defaultLower; //18
	int defaultUpper; //60
	
	//non required method to call before everything else is called, takes our annotation
	public void initialize(Age age){
		
		//do intialization work before validating
		
		//capture default values
		this.defaultLower = age.lower(); //get 18
		this.defaultUpper = age.upper(); //get 60
		
		
	}
	
	//required method to write business logic
	//value is the caputured value user will input
	@Override
	public boolean isValid(Integer userAge, ConstraintValidatorContext context) {
		
		//write business logic
		
		if(userAge == null) {
			return false; 
		}
		
		if(userAge < defaultLower || userAge > defaultUpper) {
			return false; //validate failed
		}
	
		return true; //validation passed
	}
	
	
}
