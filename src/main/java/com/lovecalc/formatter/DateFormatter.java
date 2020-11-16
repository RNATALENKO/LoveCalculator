package com.lovecalc.formatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	@Override
	public String print(Date object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date parse(String dateString, Locale locale) throws ParseException {
		
		//first split the string based on regex
		String[] dateArray = dateString.split("/");
		
		
		
		
		return null;
	}

}
