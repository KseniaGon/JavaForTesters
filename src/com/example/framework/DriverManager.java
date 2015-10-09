package com.example.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	private static WebDriver driver;
	private static String baseUrl;

	public DriverManager(String baseUrl) {
		DriverManager.baseUrl = baseUrl;
	}

	public WebDriver getWebDriver() {
	    if( driver==null ) {
	    	driver = new FirefoxDriver();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	    return driver;
	  }

	public void tearDown() throws Exception {
	    driver.quit();
	}

	public void setUp() {
	    getWebDriver().get(baseUrl + "/addressbookv4.1.4/");
	}

}
