package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(id="username")WebElement userName;
	@FindBy(id="password")WebElement password;
	@FindBy(id="loginbutton")WebElement login;
	
	public void logintoMACU(String  username,String Password) {
		
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			
		}
		userName.sendKeys(username);
		password.sendKeys(Password);
		login.click();
		
	}

}
