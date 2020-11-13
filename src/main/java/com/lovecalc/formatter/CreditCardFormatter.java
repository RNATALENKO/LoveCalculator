package com.lovecalc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.lovecalc.billDto.CreditCard;

public class CreditCardFormatter implements Formatter<CreditCard> {

	//formatters return the object of conversion
	//convert objec to string
	@Override
	public String print(CreditCard object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	//convert string to object
	//cardNumber is the user's input
	@Override
	public CreditCard parse(String cardNumber, Locale locale) throws ParseException {
		
		System.out.println("in credit card parse method");
		
		CreditCard card = new CreditCard(); 
		
		//split the string in four by hyphen
		String[] creditArray = cardNumber.split("-");
		
		//set credit card object values
		card.setFirstFour(Integer.valueOf(creditArray[0]));
		card.setSecondFour(Integer.valueOf(creditArray[1]));
		card.setThirdFour(Integer.valueOf(creditArray[2]));
		card.setFourthFour(Integer.valueOf(creditArray[3]));
		
		return card;
	}

}
