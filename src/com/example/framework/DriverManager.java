package com.example.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	private static WebDriver driver;

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

	public void initialize(String baseUrl) {
	    getWebDriver().get(baseUrl);
	}
	
}
