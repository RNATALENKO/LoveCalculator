package com.lovecalc.customeditors;

import java.beans.PropertyEditorSupport;

import com.lovecalc.billDto.CreditCard;

public class CreditCardEditor extends PropertyEditorSupport {
	
	
	@Override
	public String getAsText() {
		
		CreditCard cc = (CreditCard)getValue();
		
		return cc.toString();
	}

	//property setAsText editor that converts credit card text into a credit card object (code taken from credit card formatter). 
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		CreditCard card = new CreditCard(); 
		
		//split the string in four by hyphen
		String[] creditArray = text.split("-");
		
		//set credit card object values
		card.setFirstFour(Integer.valueOf(creditArray[0]));
		card.setSecondFour(Integer.valueOf(creditArray[1]));
		card.setThirdFour(Integer.valueOf(creditArray[2]));
		card.setFourthFour(Integer.valueOf(creditArray[3]));
		
		//System.out.println("card number is: " + card.toString());
		
		setValue(card);
			
	}
}
