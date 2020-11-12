package com.lovecalc.customvalidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


//validator definition with default ages and message

@Constraint(validatedBy = AgeConstraint.class)
@Documented
@Retention(RetentionPolicy.RUNTIME) //class where we find runtime
@Target(ElementType.FIELD) //enum where we find element types
public @interface Age {
	
	int lower() default 18; 
	int upper() default 60; 
	
	//load in values you set in Age(lower =, upper = )
	String message() default "{invalidAgeMessage}";
	
	//required methods
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };

}
