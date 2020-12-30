package com.lovecalc.exceptionhandling;

import org.springframework.stereotype.Component;

//@Component creates an object within spring application context, 
//which can be used with @Autowired to inject object
//@Autowired won't work if @Component is not present

//@Component missing intentionally to show http 500 error null pointer exception
public class ServerInfo {
	
	private String ip = "222:111:333";

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	

}
