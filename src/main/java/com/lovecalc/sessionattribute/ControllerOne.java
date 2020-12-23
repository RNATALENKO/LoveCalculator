package com.lovecalc.sessionattribute;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lovecalc.config.AppConfiguration;

/*
 * 
 * https://www.youtube.com/watch?v=ezty6XhOpF8
 * 
 */

@Controller
@SessionAttributes({"firstName", "lastName"}) //becomes availble in every model created in request scope
//data gets automatically added to each model from session, so in your view just call it ${lastName}
public class ControllerOne {
	
	@RequestMapping("/first")
	public String showPage(Model model, HttpServletRequest request) {
		
		//create a session on a request of the first page, store address into session
		HttpSession session = request.getSession(true);
		session.setAttribute("address", "1234 141st St.Louis");
		
		model.addAttribute("firstName", "Rodion");
		model.addAttribute("lastName", "Natalenko");
		
		//store value of next page
		model.addAttribute("next", "second");
		
		return "index";
	}
	
	@RequestMapping("/second")
	public String showPage2(Model model,  SessionStatus status) {
		
		//get the first name from above model
		String firstName = (String)model.getAttribute("firstName");
		
		String lastName = (String)model.getAttribute("lastName");
		
		System.out.println(firstName); //prints rodion instead of null
		System.out.println(lastName);
		
		model.addAttribute("next", "third");
		
		//removes so that the session data is not available for third handler
		status.setComplete();
		
		
		return "index";	
	}
	
	//will not receive session data in request because of status complete
	@RequestMapping("/third")
	public String showPage3(Model model) {
		
		/*gets the model data that was created by session attributes
		String lastName = (String) model.getAttribute("lastName");
		System.out.println("lastname from third model: " + lastName); 
		*/
		
		model.addAttribute("next", "fourth");
		
		return "index";
		
	}
	
	
	@RequestMapping("/fourth")
	public String showPageFour(Model model) {
		
		model.addAttribute("next", "fifth");
		
		return "index";
		
	}

}
