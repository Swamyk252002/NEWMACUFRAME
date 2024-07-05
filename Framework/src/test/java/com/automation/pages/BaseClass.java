package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utilities.Browserfactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUPSuite() {
		
		Reporter.log("Setting Up reports and Test is getting ready ",true);
		
		 excel= new ExcelDataProvider();
		 config=new ConfigDataProvider();
		 ExtentSparkReporter extent= new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/FreeCRM"+Helper.getCurrentDateTime() +".html");
		 report= new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("Setting Up reports and Test  can be Started",true);
	}
	
	@BeforeClass
	public void setup() {
		Reporter.log("Application ready",true);
		driver=Browserfactory.startApplication(driver, config.getBrowser(),config.getStagingURL());
		Reporter.log("Application to Execute ready",true);
	}
	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}
		Reporter.log("Browser ready",true);
		Browserfactory.quiteBrowser(driver);
		Reporter.log("Browser Executed ready",true);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("Test is about to End",true);
		if(result.getStatus()==ITestResult.FAILURE) { 
			Helper.captureScreenShot(driver);
			//logger.fail("Test Failed",MediaEntryBuilder.)
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		Reporter.log("Test Completed",true);
		report.flush();
	}
}
