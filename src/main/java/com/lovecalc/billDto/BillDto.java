package com.lovecalc.billDto;


import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;

@Controller
public class BillDto {
	
	
	private CreditCard creditCard;
	
	
	private BigDecimal amount; 
	
	
	private Currency currency; 
	
	
	private Date date; 
	
	private String test; 
	
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	@Override
	public String toString() {
		return "BillDto [amount=" + amount + ", currency=" + currency + ", date=" + date + ", creditCard=" + creditCard
				+ "]";
	} 
	
	

}
