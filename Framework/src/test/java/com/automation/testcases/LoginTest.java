package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;

public class LoginTest extends BaseClass {
	
	
	@Test(priority=1)
	public void loginApp() {
		
		logger=report.createTest("Open the MACU Application");
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		
		logger.info("Starting Application");
		//loginPage.logintoMACU(excel.getStringData("login", 0, 0),excel.getStringData("login", 0, 1));
		//loginPage.logintoMACU("automation_testing","Welcome123");
		
		logger.pass("Open done ");
	}
	@Test(priority=2)
    public void loginApp1() {
		
		logger=report.createTest("Login to CRM");
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		
		logger.info("Starting Application");
		
		loginPage.logintoMACU(excel.getStringData("login", 0, 0),excel.getStringData("login", 0, 1));
		//loginPage.logintoMACU("automation_testing","Welcome123");
		
		logger.pass("Login done ");
	}
	@Test(priority=3)
	public void loginApp2() {
		
		logger=report.createTest("Log out");
		
		logger.fail("Login failed ");
	}

}
