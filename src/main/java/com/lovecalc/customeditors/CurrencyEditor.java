package com.lovecalc.customeditors;

import java.beans.PropertyEditorSupport;
import java.util.Currency;


//remember to register currency editor to the property within init binder
public class CurrencyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		//takes the input text and makes it all upper
		String uppercaseCurrency = text.toUpperCase();
		
		
		Currency currency = Currency.getInstance(uppercaseCurrency);
		
		setValue(currency);
		
		
	}
	
	

}
