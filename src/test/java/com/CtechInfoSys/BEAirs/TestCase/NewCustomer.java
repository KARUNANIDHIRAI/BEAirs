package com.CtechInfoSys.BEAirs.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	WebDriver lDriver;
	NewCustomer(WebDriver rDriver){
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy(xpath = "//a[@href='addcustomerpage.php'][contains(.,'New Customer')]")
	@CacheLookup 
	WebElement newCustomer;
	
	@FindBy(how=How.XPATH, using="//input[contains(@name,'name')]")
	@CacheLookup 
	WebElement Name;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup 
	WebElement gender;

	@FindBy(how=How.ID, using="dob")
	@CacheLookup 
	WebElement dateOfBirth;	
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup 
	WebElement address;	
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup 
	WebElement city;	
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup 
	WebElement state;	
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup 
	WebElement pinNo;	
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup 
	WebElement telephoneNo;	
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup 
	WebElement emailId;	
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup 
	WebElement password;	
	
	@FindBy(how=How.NAME, using="sub")
	@CacheLookup 
	WebElement submit;	
	
	@FindBy(how=How.NAME, using="res")
	@CacheLookup 
	WebElement reset;	
	

	public void setName(String name) {
		Name.sendKeys(name);
	}

	public void setGender() {
		gender.click();
	}
	
	public void setDOB(String dd, String mm, String yy) {
		dateOfBirth.sendKeys(dd+mm+yy);
	}
	
	public void setAddress(String addres) {
		address.sendKeys(addres);
	}

	public void setCity(String City) {
		city.sendKeys(City);
	}

	public void setState(String State) {
		state.sendKeys(State);
	}
	public void setPinNo(String PinNo) {
		pinNo.sendKeys(PinNo);
	}
	
	public void setTelephoneNo(String TelephoneNo) {
		telephoneNo.sendKeys(TelephoneNo);
	}
	public void setEmailId(String EmailId) {
		emailId.sendKeys(EmailId);
	}

	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	public void clickSubmitBtn() {
		submit.click();
	}

	public void clickResetBtn() {
		reset.click();
		Name.sendKeys("");
		dateOfBirth.sendKeys("        ");
		address.sendKeys("");
		city.sendKeys("");
		state.sendKeys("");
		pinNo.sendKeys("");
		telephoneNo.sendKeys("");
		emailId.sendKeys("");
		password.sendKeys("");

	}
}
