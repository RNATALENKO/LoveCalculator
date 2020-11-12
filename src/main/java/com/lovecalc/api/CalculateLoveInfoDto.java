package com.lovecalc.api;



import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/*
 * validation annotations
 * @NotBlank - cannot be empty, used for only strings and collections
 * @Size - specifies how long characters must be for string inputs
 * @Min/@Max specifies values for numeric types
 * @AssertTrue - asserts a boolean is true or false
 * @NotNull used for Integer types, integer type can't be left blank
 * @Past used for past birthdates, and cannot enter date sometime after present day
 * @Future, used when you need users to enter a future date
 * @Email to validate if email valid or not (uses regex to see if there's an @ symbol, a valid domain etc..
 * 
 */


//object that helps transfer data
public class CalculateLoveInfoDto {
	
	@NotBlank(message = "* your name cannot be blank")
	@Size(min = 3, max=15, message = "* your name must be between 3 and 15 characters")
	private String yourName;  //Default values
	
	@NotBlank(message = "* your crush name cannot be blank")
	@Size(min = 3,max=15, message = "* your crush name must be between 3 and 15 characters")
	private String crushName;
	
	@AssertTrue(message = "You must agree to the fun terms and condition!")
	private Boolean agreement; 
	
	@NotNull(message = "you must enter a number")
	@Min(value = 1, message = "You had to have at least 1 failed attempt to use this calculator")
	private Integer failedTimes; 
	
	
	//write a custom annotation that determines whether the email is valid
	//your email goes here
	private CommunicationDto commDto; 
	
	
	public Boolean getAgreement() {
		return agreement;
	}
	public void setAgreement(Boolean agreement) {
		this.agreement = agreement;
	}
	public String getYourName() {
		return yourName;
	}
	public void setYourName(String yourName) {
		this.yourName = yourName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
	public Integer getFailedTimes() {
		return failedTimes;
	}
	public void setFailedTimes(Integer failedTimes) {
		this.failedTimes = failedTimes;
	}
	
	
	public CommunicationDto getCommDto() {
		return commDto;
	}
	public void setCommDto(CommunicationDto commDto) {
		this.commDto = commDto;
	}
	@Override
	public String toString() {
		return "CalculateLoveInfoDto [yourName=" + yourName + ", crushName=" + crushName + "]";
	}
	
}
