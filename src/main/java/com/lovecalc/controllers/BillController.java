package com.lovecalc.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalc.billDto.BillDto;

@Controller
public class BillController {
	
	
	@RequestMapping("/bill")
	public String billPage(@ModelAttribute("BillDto") BillDto billDto) {
		
		return "bill-page";
	}
	
	@RequestMapping("/bill-process")
	public String billProcessPage(@Valid @ModelAttribute("BillDto") BillDto billDto, BindingResult results) {
		
		if(results.hasErrors()) {
			return "bill-page";
		}
		
		return "bill-process";
	}
	
	//this binder will convert a new format entered into input, into the Date dto property
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		
		//Note: this will override the dd/mm/yyy format in date parser
		//create date format that will be input
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
		
		//register editor with the targeted property
		binder.registerCustomEditor(Date.class, "date", dateEditor);
		
		
	}
	
	

}
