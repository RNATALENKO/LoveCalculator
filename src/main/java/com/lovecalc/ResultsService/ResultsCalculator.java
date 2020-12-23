package com.lovecalc.ResultsService;

import org.springframework.expression.spel.ast.OperatorMatches;

public class ResultsCalculator implements Calculator {
	
	String[] matches = {"Friends", "Love", "Affection", "Marriage", "Incompatible"};

	@Override
	public void calculate(String yourName, String crushName, String[] matches) {
		
		
		//get the total length of yourname and crush name
		int total = yourName.length() + crushName.length();
		
		
		int index = 0; 
		
		
		//get from unit test
		
		
	}

}
