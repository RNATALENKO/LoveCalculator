package com.lovecalc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lovecalc.formatter.PhoneFormatter;


@Configuration
@ComponentScan(basePackages = "com.lovecalc.controllers")
@EnableWebMvc
//webmvc configurer is to add external resources like javascript pages
public class AppConfiguration implements WebMvcConfigurer {
	
	
	//create view resolver
	@Bean
	public InternalResourceViewResolver resolve() {
		System.out.println("configuring the view resolver...in AppConfig");
		InternalResourceViewResolver vr = new InternalResourceViewResolver(); 
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr; 
	}
	
	
	//add formatters
	@Override
	public void addFormatters(FormatterRegistry registry) {
	
		registry.addFormatter(new PhoneFormatter());
	}
	
	
	
	//add the resource handlers
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
	}

}
