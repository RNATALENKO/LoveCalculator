package com.lovecalc.config;

import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
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
	
	
	//register properties file to message source
	@Bean
	public MessageSource messageSource() {
		
		//set resource bundle to properties file name
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource(); 
		ms.setBasename("messages");
		
		return ms;	
	}
	
	//register message source with factory bean
	@Bean
	public LocalValidatorFactoryBean validator(){
		
		//this validates the messages properties file
		LocalValidatorFactoryBean fb = new LocalValidatorFactoryBean();
		fb.setValidationMessageSource(messageSource());
		return fb; 
		
	}
	
	//use factory bean to get a custom validator
	@Override
	public org.springframework.validation.Validator getValidator() {
		return validator(); //return the validator we created with ms
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
