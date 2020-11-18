package com.lovecalc.customeditors;

import java.beans.PropertyEditorSupport;



//a custom editor for init binder to mae input text all lower case

public class StringLowerEditor extends PropertyEditorSupport {

	//use source > override/implement methods > override setAs Text
	//input string will be passed into text
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		String lowercaseName = text.toLowerCase(); //change text to all lower case
		
	
		
		setValue(lowercaseName); //setValue is an inherited method which sets modified object
	}
	
	

}
