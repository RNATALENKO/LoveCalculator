package com.lovecalc.formatter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DecimalFormatter implements Formatter<BigDecimal> {

	@Override
	public String print(BigDecimal object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	//convert amount string to a big decimal
	@Override
	public BigDecimal parse(String amountString, Locale locale) throws ParseException {
		
		System.out.println("in decimal parser");
		
		char[] charArray = amountString.toCharArray();
		
		BigDecimal amount = new BigDecimal(charArray);
		
		//return the type of amount
		System.out.println(amount instanceof BigDecimal);
		
		return amount;
	}
	
	

}
