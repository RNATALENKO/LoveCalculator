package com.lovecalc.api;


//A class that can be nested into multiple other dto's
public class CommunicationDto {
	
	private String email; 
	private Phone phone; 
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "CommunicationDto [email=" + email + ", phone=" + phone + "]";
	}
	
	

}
