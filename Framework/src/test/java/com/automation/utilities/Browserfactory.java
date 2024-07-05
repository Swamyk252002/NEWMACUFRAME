package com.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserfactory {
	
	public static WebDriver startApplication(WebDriver driver,String browserName, String appURL) {
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SwamyKalaveni\\OneDrive - SoftClouds LLC\\Desktop\\MACU\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else {
		    System.out.println("We do not support this broswer");	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(appURL);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   return driver;
	}
	
	public static void quiteBrowser(WebDriver driver) {
		driver.quit();
	}

}
