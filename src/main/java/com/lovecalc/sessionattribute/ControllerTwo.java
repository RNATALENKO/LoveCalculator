package com.lovecalc.sessionattribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

//goal is to access a model from another controller, from a session scopes

@Controller
public class ControllerTwo {
	
	
	@RequestMapping("/fifth")
	//@sessionattribute takes the object lastName's data from first controller, stores in seshLastName
	public String showPage5(/*@SessionAttribute("lastName") String seshLastName,*/ Model model, HttpSession session) {
		
		//access attribute firstname from other controller
		//null because model not in request scope
		//String firstName = (String)model.getAttribute("firstName");
		
		//then add the sesh last name to the model, now you should be able to get the last name from session scope
		//String formalLast = "Mr." + seshLastName;
		//model.addAttribute("lastName", formalLast);
		
		//retrieving session data
		String homePhrase = (String)session.getAttribute("address") + "Home sweet home";
		model.addAttribute("address", homePhrase);
		
		session.invalidate();
		
		return "index";
	}

}
