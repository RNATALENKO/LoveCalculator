package com.lovecalc.unittests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateFormatTest {

	@Test
	public void test() {
		
		
		//simpledateformat allows parseing text to date object and vice versa
		String dateString = "02/10/1990";
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date currentDate = simpleFormat.parse(dateString);
			String currentDateString = simpleFormat.format(currentDate);
			System.out.println(currentDateString);
			System.out.println(dateString);
			assertTrue(currentDateString.equals(dateString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}
