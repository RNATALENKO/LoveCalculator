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
			System.out.println(simpleFormat.format(currentDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}
