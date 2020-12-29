package com.lovecalc.unittests;

import static org.junit.Assert.*;

import java.lang.invoke.VarHandle;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.junit.Before;
import org.junit.Test;

public class ResultsCalculator {
	

	@Test
	public void test() {
		
		//testing results calculator logic
		String[] matches = {"Friends", "Love", "Affection", "Marriage", "Incompatible"}; //length 5, max index 4
		int luckyNumber =11; 
		int index = luckyNumber%5;
		String result = matches[luckyNumber];
		
	}

}
