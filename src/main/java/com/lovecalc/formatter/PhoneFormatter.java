package com.lovecalc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.lovecalc.api.Phone;



public class PhoneFormatter implements Formatter<Phone> {

	//used to convert phone object into string for display
	@Override
	public String print(Phone phone, Locale locale) {
		
		//print method returns phone string of country code and phone string of number
		return phone.getCountryCode() + "-" + phone.getUserNumber(); 
		
	}
	
	
	//takes in a string object, from your input
	//locale is used into convert into different languages
	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		
		System.out.println("Parse method called...");
		
		//split the string received from user into an array
		String[] phoneNumberArray = completePhoneNumber.split("-");
		
		
		//extract the country code and set it to phone class country code property
		Phone phone = new Phone();
		
		
		//get index of "-"
		int indexOfHyphen = completePhoneNumber.indexOf("-");
		System.out.println("Index of hyphen is: " + indexOfHyphen);
		
		
		//if array is greater then one, set country code and number based on split
		if(phoneNumberArray.length > 1 && indexOfHyphen != 0) {
			
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}
		
		//if hyphen is the first char
		else if(indexOfHyphen == 0) {
			
			//get the hyphenated string
			String unhyphenatednumber = completePhoneNumber.replace("-", "");
			phone.setUserNumber(unhyphenatednumber);
			phone.setCountryCode(null);
			
		}
		
		//if hyphen doesn't exist
		else if(indexOfHyphen == -1) {
			phone.setUserNumber(phoneNumberArray[0]);
			phone.setCountryCode(null);
		}
		
		
		/*
		//if array only contains 1, && that value is greater then 2
		if(phoneNumberArray.length == 1 && phoneNumberArray[0].length() > 2 && indexOfHyphen != 0) {
			
			//set it as the user number
			phone.setUserNumber(phoneNumberArray[0]);
			
			//set the country code to null
			phone.setCountryCode(null);
			
		}
		
		//otherwise if the array contains two values from the split
		else if(phoneNumberArray.length > 1 && indexOfHyphen == 0) {
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}
		
		else if(indexOfHyphen == 0) {
			
			//get the phone number
			String hyphenated = phoneNumberArray[0];
			
			//remove the hyphen
			String unhyphenated = hyphenated.replace("-", ""); 
			
			//set it to the phone object's userNumber property
			phone.setUserNumber(unhyphenated);
			
			//set the country code to null
			phone.setCountryCode(null);
			
		}
		*/
		
		
		//return the populated phone properties
		return phone;
	}
}
