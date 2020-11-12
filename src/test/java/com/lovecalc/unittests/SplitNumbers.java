package com.lovecalc.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitNumbers {

	
	//test the output of the split method if users input invalid form 
	@Test
	public void test() {
		String invalidNumber = "1234567";
		
		//if the regex doesn't exist, then split method should return the string
		String[] completePhoneNumber = invalidNumber.split("-");
		
		String[] expectedArray = new String[1];
		expectedArray[0] = invalidNumber;
		
		assertArrayEquals(completePhoneNumber, expectedArray);
		
		for( String number : completePhoneNumber) {
			System.out.println(number);
		}
	}
}
