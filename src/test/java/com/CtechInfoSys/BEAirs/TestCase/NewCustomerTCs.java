package com.CtechInfoSys.BEAirs.TestCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CtechInfoSys.BEAirs.PageObject.BELoginPage;
import com.CtechInfoSys.BEAirs.PageObject.NewCustomer;
import com.CtechInfoSys.BEAirs.Utilities.Utility;
import com.CtechInfoSys.BEAirs.Utilities.XLUtils;
public class NewCustomerTCs extends BaseClass {
	XLUtils Xlutil = new XLUtils();
	@Test(dataProvider = "AddNewCustomer")
	public void NewCustomerTC1( String LoginUID, String LoginPWD,
		String Name, String Gender, String DOB, String Addres, String City,
		String State, String PinNo, String TelephoneNo, String EmailId,
		String Password	) {
		try {
			logger.info("TEST CASE START :" + driver.getCurrentUrl());
			BELoginPage lp = new BELoginPage(driver);

			logger.info("Enter User Id :" + "LoginUID" );
			lp.setUserID(LoginUID);
			logger.info("Enter Password :" + "LoginPWD");
			lp.setPassword(LoginPWD);
			logger.info("Click Submit button ");
			lp.loginSubmit();
			Thread.sleep(3000);
			
			NewCustomer AddCustomer = new NewCustomer(driver);

			logger.info("clicked on New Customer Link");
			AddCustomer.clickAddcustomer();
			Thread.sleep(3000);

			logger.info("Enter Customer Name : " +Name);
			AddCustomer.setName(Name);
			logger.info("click gender :" + Gender);
			AddCustomer.clickGender();
			
			Thread.sleep(1000);
			logger.info("Enter Data of Birth :" + DOB);
			AddCustomer.setDOB(DOB.substring(1,2),DOB.substring(2,4),DOB.substring(4,8));
			logger.info("Enter Address :" +Addres);
			AddCustomer.setAddress(Addres);
			logger.info("Entred City Name :" +City);
			AddCustomer.setCity(City);
			logger.info("Entred State Name :" +State);
			AddCustomer.setState(State);
			logger.info("Entred Pin Code: " +PinNo);
			AddCustomer.setPinNo(PinNo);
			Thread.sleep(2000);
			logger.info("Entred Telephone No."+TelephoneNo);
			AddCustomer.setTelephoneNo(TelephoneNo);
			logger.info("EmailId :"+EmailId);
			String CustEmailId= Utility.getRandomString(6)+"Gmail.COM";
			AddCustomer.setEmailId(CustEmailId);
			logger.info("Entred Customer Password:" + Password);
			AddCustomer.setPassword(Password);
			logger.info("Click submit button:" + Password);
			AddCustomer.clickSubmitBtn();
			Thread.sleep(3000);
			logger.info("Validataion Start  ...................");
			if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
				Assert.assertTrue(true);
				logger.info("Test Case Passed.......");
				Thread.sleep(2000);
			}
			else {
				Assert.assertTrue(false);
				logger.info("Test Case Failed.....");
			}
			driver.get(URL);
		}
		catch (InterruptedException e) {
			Assert.assertTrue(false);
			//captureScreen(driver,"AddnewCustomer");
			logger.info("Catch block --> Test Case Failed.....");
		}
	}

	@DataProvider(name="AddNewCustomer")
	String [][] getData(){
		try {
			XLUtils objXLUtil = new XLUtils();
			String [][] loginData=objXLUtil.getXLData("AddNewCustomer");
			logger.info("Total Row in Datasheet :"+ loginData.length) ;
			logger.info("Total Col in Datasheet :"+ loginData[0].length) ;
            String tempData ;
			for(int i=1;i<=loginData.length;i++) {// read all data from array
			 	tempData="";
			    for(int j=0;j<loginData[i-1].length;j++) { // read data from all col
			    	tempData+= j+ " ) " +loginData[i-1][j];
				}			  		
		    	logger.info( "parameter list: " + tempData ); // print parameter value of excel data sheet
			}
			return loginData;
		}
		catch (Exception e) {
			logger.info("String [][] getData() : getting Excel data sheet Error : " + e);
			String dataLogin[][]= new String[0][0];
			return dataLogin;
			
		}
	}
	
}
