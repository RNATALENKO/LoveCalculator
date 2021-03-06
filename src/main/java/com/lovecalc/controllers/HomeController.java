package com.lovecalc.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lovecalc.ResultsService.Calculator;
import com.lovecalc.ResultsService.ResultsCalculator;
import com.lovecalc.api.CalculateLoveInfoDto;


/*
 * 
 *  Some notes
 *  
 *  Each page and controller should have it's own Dto that it can pull from
 * 
 */


@Controller

//pass the @ModelAttribute("name") into the annotation, model data gets stored
//@SessionAttributes({"loveDto", "otherdto", "otherDto"}) multiple object storage, not sure how to retrieve single index with @SessionAttribute
@SessionAttributes("loveDto")

public class HomeController {
	
	
	@Autowired
	private ResultsCalculator calculator; 
	
	
	
	@RequestMapping("/")
	public String home(/*@ModelAttribute("loveDto") CalculateLoveInfoDto loveDto,*/ Model model) {
		model.addAttribute("loveDto", new CalculateLoveInfoDto());
		return "home-page";
	}
	
	@RequestMapping("/results")//once you create the object here, the values are set automatically by Spring
	public String processHome(@Valid @ModelAttribute("loveDto") CalculateLoveInfoDto loveDto, 
			BindingResult result) {
		
		
		/*server side validation*/
		//if form has any errors
		if(result.hasErrors()) {
			
			//print out form was invalid in console
			System.out.println("form was invalid"); //will not work unless you have hibernate validator
			
			//print out and log all errors
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			
			//do not allow users to go to next page by returning current page
			return "home-page";
			
		}
		
		//validation for aggreement check
		if(loveDto.getAgreement() == false) {
			System.out.println("Error: user agreement unchecked");
			return "home-page"; 
		}
		
		//validation for number of failed attempts
		if(loveDto.getFailedTimes() < 0) {
			System.out.println("Error: user didn't put in a value large enough");
			return "home-page"; 
		}
		 
		
	
		//create a session from httprequest object, and set the dto data into the session
		/*
		 *  to utilize this make sure to pass the http servlet object HttpServletRequest request into method
		HttpSession session = request.getSession(true); //get a session if it exists, otherwise create a new one
		session.setAttribute("sessionYourName", loveDto.getYourName()); //set the data for the session
		*/
		
		
		
		
		
		//Service layer: before going to the results page, write logic to calculate love
		//Then send result to the result page
		
		//get love calculation
		//set to current model
		String loveResults = calculator.calculate(loveDto.getYourName(), loveDto.getCrushName(), loveDto.getFailedTimes());
		loveDto.setResult(loveResults);
		
		
		
		return "results-page"; //replace with results-page, email-page for visual testing
	}
	
	
	/*long way of passing data to a view
	@RequestMapping("/process-homepage")//once you create the object here, the values are set automatically by Spring
	public String processHome(CalculateLoveInfoDto loveDto, Model model) {
		//here we are writing the input data into the DTO object
		//add the object with auto-binded variables to the model
		model.addAttribute("loveDto", loveDto);
		return "process-homepage";
	}
	*/
}
