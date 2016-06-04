package com.zingaretti.bix;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Rink {
	static Logger logger;
	   
	static {
	  	logger = Logger.getLogger("com.appinf");
	  	logger.logp(Level.INFO,"Rink","static","ENTER");
	}
	   	
	
	private String rinkName;
	private String address;
	private String stateCode;
	private String zipCode;
	private String managerPhone;
	private String managerEmail;
	private String password;
	
	public Rink()
	{
		logger.logp(Level.INFO,"Rink","CTOR","ENTER");
		
	}
		
	public String getRinkName() {
		logger.logp(Level.INFO,"Rink","getRinkName","ENTER");
		return rinkName;
	}
	public void setRinkName(String firstName) {
		logger.logp(Level.INFO,"Rink","setRinkName","ENTER");
		this.rinkName = rinkName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.zipCode = stateCode;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
