package com.lovecalc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DispatchInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		
		System.out.println("OnStartup method called in initializer...");
		AnnotationConfigWebApplicationContext acwac = new AnnotationConfigWebApplicationContext(); 
		acwac.register(AppConfiguration.class);
		
		DispatcherServlet ds = new DispatcherServlet(acwac);
		
		ServletRegistration.Dynamic srd = servletContext.addServlet("DispatcherServlet", ds);
		srd.setLoadOnStartup(1);
		srd.addMapping("/");
		

	}
	

	

}
