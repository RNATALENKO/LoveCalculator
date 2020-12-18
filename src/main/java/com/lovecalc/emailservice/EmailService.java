package com.lovecalc.emailservice;

import org.apache.catalina.ha.backend.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements Email {
	
	//to send the email use JavaMailSender class
	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendEmail(String email, String message) {
		
		//write logic that sends the message to the email
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo(email);
		simpleMessage.setSubject("Love Calc Results");
		simpleMessage.setText(message);
		
		//send the message
		sender.send(simpleMessage);
			
	}

}
