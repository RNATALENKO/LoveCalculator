package com.lovecalc.unittests;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.junit.Test;

public class LocaleTest {

	
	@Test
	public void test() {
		
		//an input amount to format
		Double amount = 234234.2344; 
		
		//gets the current locale inoformation
		//locale defines users lang, region, and preferences
		Locale currentLocale = Locale.getDefault();
		System.out.println(currentLocale);
		
		//get currency instance from locale
		Currency localCurrency = Currency.getInstance(currentLocale);
		System.out.println(localCurrency);
		
		//returns the currency formatter for the user's current region
		NumberFormat currencyFormatter = NumberFormat.getInstance(currentLocale);
		System.out.println(currencyFormatter.format(amount));
		
	}

}
