package com.lovecalc.converters;

import org.springframework.core.convert.converter.Converter;

import com.lovecalc.billDto.CreditCard;

public class CreditCardConverterPrint implements Converter<CreditCard, String> {

	@Override
	public String convert(CreditCard source) {
		
		return "convertor print: " + source.toString();
	}

}
