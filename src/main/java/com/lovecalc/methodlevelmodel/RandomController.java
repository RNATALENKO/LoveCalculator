package com.lovecalc.methodlevelmodel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@ControllerAdvice(assignableTypes = TestController.class) //model attribute available to one class
//@ControllerAdvice(basepackages = {"com.lovecalc.controllers", "com.lovecalc.sessionattributes"});

//as soon as /show page is requested, data persisted into session
@SessionAttributes("info")
public class RandomController {
	
	
	//method that returns infodto
	//executed first when controller accessed
	@ModelAttribute("info")
	public infoDto getInfoDto() {
		
		infoDto info = new infoDto();
		info.setWebsite("www.lovecalc.com");
		info.setWebsiteCategory("Calc and dating");

		return info; 
	}
	
	//pages that will use same dto data
	@RequestMapping("/show")
	public String showInfo(@ModelAttribute("info") infoDto info) {
		
		info.setWebsite("website test to session");
		info.setWebsiteCategory("category test to session");
		
		return "show-info";
	}
	
	
	@RequestMapping("/showinfo")
	public String showMoreInfo() {
		
		return "show-info";
	}
	
	//retrieving dto from @ModelAttribute which passed to Model
	@RequestMapping("/showmoreinfo")
	public String showMoreInfoTwo(Model model) {
		
		
		infoDto info = (infoDto)model.getAttribute("info");
		
		return "show-info";
	}
	
	//controller that uses @M in parameter
	//the param level retains the method level data
	@RequestMapping("/insideparam")
	public String insideParam(@ModelAttribute("info") infoDto info ) {
		
		//getInfoDto();
		System.out.println(info.getWebsite());

		return "show-info";
	}

}
