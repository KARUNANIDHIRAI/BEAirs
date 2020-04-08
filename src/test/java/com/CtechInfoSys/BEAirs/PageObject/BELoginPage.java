package com.CtechInfoSys.BEAirs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BELoginPage {
	WebDriver lDriver;
	
	public BELoginPage(WebDriver rDriver) {
		lDriver= rDriver;
		PageFactory.initElements(rDriver,this);
	}

	/*	@FindBy(name="email")   @CacheLookup WebElement email;
	@FindBy(name="pass") @CacheLookup WebElement pass;
	@FindBy(id="u_0_b") @CacheLookup WebElement u_0_2;

*/
	@FindBy(name="uid") @CacheLookup WebElement email;
	@FindBy(name="password") @CacheLookup WebElement pass;
	@FindBy(name="btnLogin") @CacheLookup WebElement u_0_2;
	@FindBy(xpath="//a[@href='Logout.php']") @CacheLookup WebElement logout;

	public void setUserID(String UID) {
		try {
			email.sendKeys(UID);
		}
		catch(Exception e) {
			System.out.println("Fail to set value : email.sendKeys(UID))");
		}
	}
	
	public void setPassword(String PWD) {
		try {
			pass.sendKeys(PWD);
		}
		catch(Exception e) {
			System.out.println("Fail to set value : pass.sendKeys(PWD))");
		}
	}
	
	public void loginSubmit() {
		try {
			u_0_2.click();
		}
		catch(Exception e) {
			System.out.println("Fail to set value : u_0_2.click())");
		}
	}	
	public void clickLogout() {
		try {
			logout.click();
		}
		catch(Exception e) {
			System.out.println("Fail to set value : logout.click())");
		}	
	}
}
