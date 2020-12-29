package com.lovecalc.ResultsService;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.expression.spel.ast.OperatorMatches;
import org.springframework.stereotype.Service;


@Service
public class ResultsCalculator implements Calculator {
	

	public final String loveFormula = "FLAMI";

	@Override
	public String calculate(String yourName, String crushName, int attempts) {
		
	
		int luckyNumber = yourName.length() + crushName.length(); 
	
		//add or subtract based on number of a attempts, subtract one to get closer to love, add one to get closer to incompatible
		if(attempts < 5) {
			luckyNumber -= 1; //closer to love
		}
		else {
			luckyNumber +=1;  //closer to incompatible
		}

		int index = luckyNumber%loveFormula.length();
	
		char luckyLetter = loveFormula.charAt(index);
		String loveResult = returnResult(luckyLetter);
		return loveResult;
	}

	@Override
	public String returnResult(char luckyLetter) {
		
		String results = null;
		
		if(luckyLetter == 'F') {
			results = LoveConstants.F_CHAR;
		}
		else if(luckyLetter == 'L') {
			results = LoveConstants.L_CHAR;
		}
		else if(luckyLetter == 'A') {
			results = LoveConstants.A_CHAR;
		}
		else if(luckyLetter == 'M') {
			results = LoveConstants.M_CHAR;
		}
		else if(luckyLetter == 'I') {
			results = LoveConstants.I_CHAR;
		}
		
		return results; 
		
	}
	
}
