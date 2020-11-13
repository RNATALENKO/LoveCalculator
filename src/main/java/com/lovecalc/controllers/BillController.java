package com.lovecalc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalc.billDto.BillDto;

@Controller
public class BillController {
	
	
	@RequestMapping("/bill")
	public String billPage(@ModelAttribute BillDto billDto) {
		
		return "bill-page";
	}
	
	@RequestMapping("/bill-process")
	public String billProcessPage(@ModelAttribute BillDto billDto) {
		
		return "bill-process";
		
	}
	
	

}
