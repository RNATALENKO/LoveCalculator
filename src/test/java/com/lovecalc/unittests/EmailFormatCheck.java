package com.lovecalc.unittests;

import static org.junit.Assert.*;

//this test will check if a given string is the correct email format

import org.junit.Test;

public class EmailFormatCheck {
	
	
	public boolean isValid(String email) {
		String regexPattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		
		return email.matches(regexPattern);
		
	}

	@Test
	public void test() {
		String sample = "rodionnatal@enkogmail.sddasf.afcom.sadf";
	
		if(isValid(sample)) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
	}
}
