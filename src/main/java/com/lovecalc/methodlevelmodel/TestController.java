package com.lovecalc.methodlevelmodel;

import java.lang.ProcessHandle.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecalc.exceptionhandling.ServerInfo;


@Controller
public class TestController {
	
	
	@RequestMapping("/out")
	public String showOut(@ModelAttribute("info") infoDto info) {
		
		//no access to Global @ModelAttributes

		return "show-info";
	}


}
