package com.CtechInfoSys.BEAirs.TestCase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.CtechInfoSys.BEAirs.Utilities.ReadConfig;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {


	ReadConfig rConfig = new ReadConfig();
	
	public String URL =rConfig.getApplicationURL(); 
	public String UID =rConfig.getAppUserName();
	public String PWD= rConfig.getApplPassword();
	
	/*
	 * public String URL ="http://www.facebook.com"; public String UID =
	 * "karunanidhirai@yahoo.com"; public String PWD= "$Mamata12708$";
	 */
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	//@BeforeClass
	@BeforeTest
	public void setup(String br) throws InterruptedException {
		try {
		    logger = Logger.getLogger("BEAirs - test setup ");
		    PropertyConfigurator.configure("log4j.properties");
		    logger.info(rConfig.getFirefoxDrvPath());
			if (br.equals("chrome")) {
			    System.setProperty("webdriver.chrome.driver",rConfig.getChromeDrvPath());  
				driver=new ChromeDriver();
			}
			else if(br.equals("firefox"))	{
			    System.setProperty("webdriver.gecko.driver",rConfig.getFirefoxDrvPath());  
				driver=new FirefoxDriver();
			}
			else if(br.equals("IE")) {
			    System.setProperty("webdriver.gecko.driver",rConfig.getIEDrvPath());  
				driver=new InternetExplorerDriver();
			}
		    logger.info("   " +br +" :" + "Driver Load Successfully");
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.get(URL);
			Thread.sleep(5000);
			String X = driver.getTitle();
			  if (driver.getTitle().equals(X)) {
				  Assert.assertTrue(true);
				  logger.info("   URL is opened successfully :" + URL);
			  } 
			  else {
				  logger.info("   URL is not opened successfully :" + URL);
				  Assert.assertTrue(false);
				  if(driver!=null) {
					  driver.quit();
				  }
				  System.exit(1);
			  }
	    }
		catch (Exception e) {
			logger.info("   " + br +": Fail to load driver Successfully : Error -->" );
			    e.printStackTrace();
		}
	    
	}
	
	//@AfterClass
	@AfterTest
	public void tearDown() {
		driver.quit();
	    logger.info("   Quit : Driver Loaded Successfully");
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws InterruptedException {
		TakesScreenshot TS  = ((TakesScreenshot)driver); 
		File SFile = TS.getScreenshotAs(OutputType.FILE);
		Thread.sleep(3000);
		File TFile = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		try {
			FileUtils.copyFile(SFile,TFile); 
			logger.info("Login TC1 failed :Screenshots take successfully");
		}
		catch (IOException e) {
			logger.info("Error in taking Screenshots for :" +tname + ":" + e);		
		}
	}
	 
}