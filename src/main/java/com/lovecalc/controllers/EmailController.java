package com.lovecalc.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lovecalc.api.CalculateLoveInfoDto;
import com.lovecalc.emailDto.EmailDto;
import com.lovecalc.emailservice.EmailService;
import com.lovecalc.springvalidation.EmailResultsValidator;

/*
 * Notes on validation: 
 * 
 * @valid is required for the model, to activate validation, including the binding results
 * 
 */


@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService; 
	
	
	/*
	 * Sending Data through URL, avoid this method:
	 * 
	 * @RequestMapping("/sendemail/{yourName}/{hobby}/{anydata") //curly braces mean
	 * you can load data in dynamically public String emailPage(@PathVariable
	 * Map<String,String> variables, Model model) {
	 * 
	 * 
	 * //get the user name from map String yourName = variables.get("yourName");
	 * 
	 * //add model attribute model.addAttribute("emailDto", new EmailDto());
	 * 
	 * //send the yourName variable to the email dto model.addAttribute("yourName",
	 * username.toUpperCase());
	 * 
	 * return "email-page"; }
	 * 
	 * 
	 */
	@RequestMapping("/sendemail")
	public String emailPage(@ModelAttribute("emailDto") EmailDto emailDto) {

		return "email-page";
	}

	@RequestMapping("/processemail")
	public String processEmail(@SessionAttribute("loveDto") CalculateLoveInfoDto loveDto, Model model, @Valid @ModelAttribute("emailDto") EmailDto emailDto, BindingResult results) {

		// need validation that email was sent successfully
		List<ObjectError> errorList = results.getAllErrors();

		if (results.hasErrors()) {

			// print the errors
			for (ObjectError errors : errorList) {
				System.out.println(errors);
			}
			return "email-page";
		}
		
		
		/* performing business logic onto session data, creating new attributes
		 * first pass in  HttpSession session argument into method
		String yourName = (String) session.getAttribute("sessionYourName"); //returns rod john etc..
		String formalName = "Mr." + yourName; //create the new string
		session.setAttribute("sessionFormalName", formalName); //set it as a new attribute for the session
		//or model.addAttribute("formalName", formalName);
		model.addAttribute("formalName", formalName);
		session.setMaxInactiveInterval(120);
		*/
		
		
		
		
		
		/*sending an email with your user info, retrieved from session with @SessionAttribute*/
		String emailMessage = "Yo, this is an email sent from" + loveDto.getYourName() + "it's just a test, can you reply to it?";
		emailService.sendEmail(emailDto.getEmail(), emailMessage);
		
		
		
		

		return "email-process";

	}

	// init binder to validate email address
	@InitBinder
	public void binder(WebDataBinder binder) {
		// add the email validator
		binder.addValidators(new EmailResultsValidator());
	}

}