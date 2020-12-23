package com.lovecalc.config;


import java.util.Properties;

import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lovecalc.converters.CreditCardConverter;
import com.lovecalc.converters.CreditCardConverterPrint;
import com.lovecalc.formatter.CreditCardFormatter;
import com.lovecalc.formatter.CurrencyFormatter;
import com.lovecalc.formatter.DateFormatter;
import com.lovecalc.formatter.DecimalFormatter;
import com.lovecalc.formatter.PhoneFormatter;
import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.*;


@Configuration
@ComponentScan(basePackages = {"com.lovecalc"})
@EnableWebMvc
@PropertySource("classpath:emailinfo.properties")

@PropertySources({@PropertySource("classpath:first.properties"),
	@PropertySource("classpath:second.properties")})
 

//beans are used to automatically create objects and set properties, every time the application and server is fired
//regster property files, create view resolver, register formatters
public class AppConfiguration implements WebMvcConfigurer {
	
	@Autowired
	private Environment env; 
	private Logger logger = Logger.getLogger(AppConfiguration.class.getName());
	
	
	
	//create view resolver
	@Bean
	public InternalResourceViewResolver resolve() {
		System.out.println("in app config...in resolve method");
		InternalResourceViewResolver vr = new InternalResourceViewResolver(); 
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr; 
	}
	
	
	/*externalizing jsp interpolation from a property file*/
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
	
		System.out.println("adding formatters...in addFormatters method");
		registry.addFormatter(new PhoneFormatter());
		//registry.addFormatter(new CreditCardFormatter()); 
		registry.addFormatter(new DecimalFormatter());
		registry.addFormatter(new CurrencyFormatter());
		registry.addFormatter(new DateFormatter());
		
		registry.addConverter(new CreditCardConverter());
		registry.addConverter(new CreditCardConverterPrint());
	}
	

	//configuring mail sender object (spring will automatically create this object, set properties, then 
	@Bean
	public JavaMailSender getJavaMailSender() {
		
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost(env.getProperty("email.host")); //host details
		senderImpl.setUsername(env.getProperty("email.username"));
		senderImpl.setPassword(env.getProperty("email.password")); //your password
		senderImpl.setPort(getIntProperty("email.port")); //gmail email port server is 587
		
		//System.out.println("mail sender host: " +  env.getProperty("email.host"));
		logger.info(">>>>>>>>>>>>>>>>Fetching host value: " + env.getProperty("email.host"));
	
		
		
		
		//because gmail security is tight, you need to set TLS and SSL properties
		Properties emailProperties = getMailProperties(); //telling SSL to trust the server
		
		senderImpl.setJavaMailProperties(emailProperties);
		
		return senderImpl;  
	}
	
	
	//add the resource handlers, for external resources/pages
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
	}
	
	
	//utilitiy methods
	//method that returns integer from a defined properties file
	int getIntProperty(String key) {
		
		String propertyString = env.getProperty(key);
		return Integer.parseInt(propertyString);
		
	}
	
	private Properties getMailProperties() {
		Properties emailProperties = new Properties();
		emailProperties.put("mail.smtp.starttls.enable", true); //Enables use of starttls command
		emailProperties.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		return emailProperties;
	}

}
