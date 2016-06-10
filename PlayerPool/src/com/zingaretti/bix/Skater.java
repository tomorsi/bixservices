package com.zingaretti.bix;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAccessType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Skater {
	static Logger logger;
	   
	static {
	  	logger = Logger.getLogger("com.appinf");
	  	logger.logp(Level.INFO,"Skater","static","ENTER");
	}
	   	
	
	private String firstName;
	private String lastName;
	private String emailPrimary;
	private String smsTextNumber;
	private String zipCode;
	private String password;
	
	public Skater()
	{
		logger.logp(Level.INFO,"Skater","CTOR","ENTER");
		
		
	}
		
	public String getFirstName() {
		logger.logp(Level.INFO,"Skater","getFirstName","ENTER");
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		logger.logp(Level.INFO,"Skater","setFirstName","ENTER");
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailPrimary() {
		return emailPrimary;
	}
	public void setEmailPrimary(String emailPrimary) {
		this.emailPrimary = emailPrimary;
	}
	public String getSmsTextNumber() {
		return smsTextNumber;
	}
	public void setSmsTextNumber(String smsTextNumber) {
		this.smsTextNumber = smsTextNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
