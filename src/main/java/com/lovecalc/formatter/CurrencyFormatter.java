package com.lovecalc.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import org.springframework.format.Formatter;

public class CurrencyFormatter implements Formatter<Currency> {

	@Override
	public String print(Currency object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Currency parse(String currencyString, Locale locale) throws ParseException {
		
		System.out.println("in currency parse method");
		
		Currency selectedCurrency = Currency.getInstance(currencyString);
		
		return selectedCurrency;
	}

}
