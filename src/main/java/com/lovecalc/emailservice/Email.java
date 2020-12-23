package com.lovecalc.emailservice;

import com.lovecalc.api.CalculateLoveInfoDto;
import com.lovecalc.emailDto.EmailDto;

public interface Email {
	
	
	//good
	void sendEmail(String email, String message);
	
	//bad for performance
	void sendEmail(EmailDto emailDto, CalculateLoveInfoDto loveDto);
	

}
