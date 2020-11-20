package com.lovecalc.operator;

public class StringOperator {
	
	
	//pass in array of strings, if a string contains the data return true
	public static boolean contains(String target, String[] data) {
		boolean results = false; 
		for(String string : data) {
			if(target.contains(string)) {
				results = true; 
			}
		}
		return results; 
	}
}
