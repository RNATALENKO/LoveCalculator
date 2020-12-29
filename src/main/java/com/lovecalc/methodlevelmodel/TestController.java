package com.lovecalc.methodlevelmodel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	
	
	@RequestMapping("/out")
	public String showOut(@ModelAttribute("info") infoDto info) {
		
		//no access to Global @ModelAttributes

		return "show-info";
	}


}
