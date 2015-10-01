package com.example.tests.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	private static WebDriver driver;

	public WebDriver getWebDriver() throws Exception {
	    if( driver==null ) {
	    	driver = new FirefoxDriver();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }
	    return driver;
	  }

	public void tearDown() throws Exception {
	    driver.quit();
	}

}
