package com.CtechInfoSys.BEAirs.TestCase;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CtechInfoSys.BEAirs.PageObject.BELoginPage;
import com.CtechInfoSys.BEAirs.Utilities.XLUtils;

public class LoginPageTCs extends BaseClass{

/*	
	@Test
	public void LoginTestCase1() throws InterruptedException  {

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
			e.printStackTrace();
		}
		String X = driver.getTitle();
		if (driver.getTitle().equals(X+"s")) {
			Assert.assertTrue(true);
			logger.info("Login TC1 passed: :" +driver.getTitle());
		}	
		else {
			logger.info("Login TC1 failed :");
			captureScreen(driver,"loginTestCase1");
			Assert.assertTrue(false);
		}
	}	
*/
	@Test(dataProvider = "LoginData")
	public void LoginTestCase1(String UID, String PWD) throws InterruptedException  {
		try {
			BELoginPage lp = new BELoginPage(driver);
				String X = driver.getCurrentUrl();		
				logger.info("Before Login Page URl :" + driver.getCurrentUrl());
				lp.setUserID(UID);
				logger.info("User Id Entered :" + UID );
				lp.setPassword(PWD);
				logger.info("Password Entered :" + PWD);
				lp.loginSubmit();
				logger.info("Submit button clicked");
				Thread.sleep(2000);

			if(isAlertPresent()==true) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
			logger.info("After Login Page URl :" + driver.getCurrentUrl());
			if (driver.getCurrentUrl().equals(X)) {
				Assert.assertTrue(false);
				logger.info("Test Case Fail User ID:" + UID + ": Password" + PWD  );
			}
			else {
				Assert.assertTrue(true);
				logger.info("Test Case1 Pass User ID:" + UID + ": Password" + PWD  );
				driver.get(X);
			}
		}
		catch (Exception e) {
			logger.info("LoginTestCase1(String UID, String PWD)" + "Error : -->" + e);
			
		}
	}		
	@Test(dataProvider = "LoginData")
	public void LoginTestCase2(String UID, String PWD) throws InterruptedException  {
		try {
			BELoginPage lp = new BELoginPage(driver);
			String X = driver.getCurrentUrl();		
			logger.info("Before Login Page URl :" + driver.getCurrentUrl());
			lp.setUserID(UID);
			logger.info("User Id Entered :" + UID );
			lp.setPassword(PWD);
			logger.info("Password Entered :" + PWD);
			lp.loginSubmit();
			logger.info("Submit button clicked");
			Thread.sleep(2000);

			if(isAlertPresent()==true) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
			logger.info("After Login Page URl :" + driver.getCurrentUrl());
			if (driver.getCurrentUrl().equals(X)) {
				Assert.assertTrue(false);
				logger.info("Login Test Case Fail User ID:" + UID + ": Password" + PWD  );
			}
			else {
				Assert.assertTrue(true);
				X=driver.getCurrentUrl();
				lp.clickLogout(); // logout button click
	            Thread.sleep(3000);
				if(isAlertPresent()==true) {
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();
				}
	            if (driver.getCurrentUrl().equals(X)) {
					Assert.assertTrue(false);
					logger.info("Logout Test Case Fail User ID:" + UID + ": Password" + PWD  );
				}
				else {
					Assert.assertTrue(true);
					logger.info("Logout Test Case Pass User ID:" + UID + ": Password" + PWD  );
				}
			}
		}
		catch (Exception e) {
			logger.info("LoginTestCase2(String UID, String PWD)" + "Error : -->" + e);
		}
	}	
	
	@DataProvider(name="LoginData")
	String [][] getData(){
		try {
			logger.info("String [][] getData() : getting data from excel sheet" );
			String dataFilePath=System.getProperty("user.dir")+"/src/test/java/com/CtechInfoSys/BEAirs/TestData/BEAirsTestData.xlsx";
			int rowCount=XLUtils.getRowCount(dataFilePath, "sheet1");
			int colCount=XLUtils.getCelCount(dataFilePath, "sheet1", 1);
			logger.info("Total Row in Datasheet"+ rowCount +": Total Colom in Datasheet :" + colCount );
			
			String loginData [][] = new String[rowCount][colCount];
			for(int i=1;i<=rowCount;i++) {
				for(int j=0;j<colCount;j++) {
					loginData[i-1][j]=XLUtils.getCelData(dataFilePath, "sheet1", i, j);
				}
			}
			/*
			 * for(int i=1;i<=rowCount;i++) {
			 * logger.info("user name:"+loginData[i-1][0]+" : password-->"+loginData[i-1][1]
			 * ); }
			 */
			logger.info("String [][] getData() : Test data upload successfully");
			return loginData;
		}
		catch (Exception e) {
			logger.info("String [][] getData() : getting Excel data sheet Error : " + e);
			String dataLogin[][]= new String[0][0];
			return dataLogin;
			
		}
	}
	
	public boolean isAlertPresent() { // Method to check alert is present or not
	    try {
	         driver.switchTo().alert();
	         return true;
	    }
	    catch (NoAlertPresentException e){
	         return false;
	    }
	}
}
