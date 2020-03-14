package com.CtechInfoSys.BEAirs.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CtechInfoSys.BEAirs.PageObject.BELoginPage;

public class LoginPageTCs extends BaseClass{
	@Test
	public void loginTestCase1()  {

        logger.info("loginTestCase1()"); 
		driver.manage().window().maximize();
		BELoginPage lp = new BELoginPage(driver);
		lp.setUserID(UID);
		logger.info("User Id Entered :" + UID );
		
		lp.setPassword(PWD);
		logger.info("Password Entered :" + PWD);
		lp.loginSubmit();
		logger.info("Submit button clicked");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String X = driver.getTitle();
		if (driver.getTitle().equals(X)) {
			Assert.assertTrue(true);
			logger.info("Login TC1 passed: :" +driver.getTitle());
		}	
		else {
			//captureScreen(driver,"loginTestCase1");
			Assert.assertTrue(false);
			logger.info("Login TC1 failed :" +driver.getTitle());
		}
	}	

}
