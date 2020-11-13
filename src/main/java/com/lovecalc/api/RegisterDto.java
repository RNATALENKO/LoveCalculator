package com.lovecalc.api;

import java.util.Arrays;

import javax.validation.constraints.NotEmpty;

import com.lovecalc.customvalidator.Age;




public class RegisterDto {
	
	@NotEmpty(message = "name cannot be empty")
	private String name; 
	private String username;
	private char[] password;
	private String country;
	private String gender;
	private String[] hobbies;
	
	@Age(lower = 15, upper = 65)
	private Integer age; 
	
	private CommunicationDto commDto; 
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public CommunicationDto getCommDto() {
		return commDto;
	}
	public void setCommDto(CommunicationDto commDto) {
		this.commDto = commDto;
	}
	
	@Override
	public String toString() {
		return "RegisterDto [name=" + name + ", username=" + username + ", password=" + Arrays.toString(password)
				+ ", country=" + country + ", gender=" + gender + ", hobbies=" + Arrays.toString(hobbies) + "]";
	}
	
	
	
	
	
	
	

	
	
	
	
	
	

}
