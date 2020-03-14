package com.CtechInfoSys.BEAirs.TestCase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.CtechInfoSys.BEAirs.Utilities.ReadConfig;
import java.io.File;
import java.io.IOException;

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
@BeforeClass
public void setup(String br) {
	//try {
	    logger = Logger.getLogger("airs");
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
        driver.get(URL);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String X = driver.getTitle();
		  if (driver.getTitle().equals(X)) {
			  Assert.assertTrue(true);
			  logger.info("   URL is opened successfully :" + URL);
		  } 
		  else {
			  logger.info("   URL is not opened successfully :" + URL);
			  Assert.assertTrue(false);
			  driver.quit();
			  System.exit(1);
		  }
   // }
//	catch (Exception e) {
		    logger.info("   " + br +": Fail to load driver Successfully");
//		    e.printStackTrace();
//	}
    
}

@AfterClass
public void tearDown() {
	driver.quit();
    logger.info("   Quit : Driver Loaded Successfully");
}

/*
 * public void captureScreen(WebDriver drive, String tname) { TakesScreenshot TS
 * = (TakesScreenshot)driver; File SFile = TS.getScreenshotAs(OutputType.FILE);
 * File TFile = new
 * File(System.getProperty("user.dir"+"/Screenshots/"+tname+".jpg")); try {
 * FileUtils.copyFile(SFile,TFile); } catch (IOException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * System.out.println("Screenshots take successfully"); }
 */
}