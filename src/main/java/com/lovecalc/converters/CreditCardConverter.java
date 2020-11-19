package com.lovecalc.converters;

import org.springframework.core.convert.converter.Converter;

import com.lovecalc.billDto.CreditCard;


//converter takes in source and target classes i.e. String to CreditCard
public class CreditCardConverter implements Converter<String, CreditCard> {

	@Override
	public CreditCard convert(String source) {
		
				CreditCard card = new CreditCard(); 

				//split the string in four by hyphen
				String[] creditArray = source.split("-");
				
				//set credit card object values
				card.setFirstFour(Integer.valueOf(creditArray[0]));
				card.setSecondFour(Integer.valueOf(creditArray[1]));
				card.setThirdFour(Integer.valueOf(creditArray[2]));
				card.setFourthFour(Integer.valueOf(creditArray[3]));
				
				//System.out.println("card number is: " + card.toString());
				
				return card;
	}

}
