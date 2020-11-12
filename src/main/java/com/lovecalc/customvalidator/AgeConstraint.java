package com.lovecalc.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


//business logic for age constraint

public class AgeConstraint implements ConstraintValidator<Age, Integer> {
	
	
	int defaultLower; //18
	int defaultUpper; //60
	
	//method called first to do initialization work, passes in age object
	public void initialize(Age age){
		
		System.out.println("In constraint initialization");
		
		//do intialization work before validating
		this.defaultLower = age.lower(); //get 18
		this.defaultUpper = age.upper(); //get 60
		
	}
	
	//method that returns true or false based on users age
	@Override
	public boolean isValid(Integer userAge, ConstraintValidatorContext context) {
		
		System.out.println("in isValid method");
		
		//write business logic
		//if users age is not given, return false
		if(	userAge == null) {
			
			return false; 
		}
		
		//if user's age less then 18 or age greater then 60 return false
		if(userAge < defaultLower || userAge > defaultUpper) {
			return false; //validate failed
		}
	
		//otherwise validation passed
		return true;
	}
	
	
}
