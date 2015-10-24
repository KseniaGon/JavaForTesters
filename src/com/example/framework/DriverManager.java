package com.example.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
	private static WebDriver driver;
	private static String browser;

	public DriverManager(String browser) {
		super();
		DriverManager.browser = browser;
	}

	public WebDriver getWebDriver() {
	    if( driver==null ) {
	    	driver = getBrowser();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	    return driver;
	  }

	protected WebDriver getBrowser() {
		switch (browser.toLowerCase()) {
			case "firefox": return new FirefoxDriver();
			case "ie": 						
				try {
					return new RemoteWebDriver(new URL("http://localhost:5555"), DesiredCapabilities.internetExplorer());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			case "chrome":	
				try {
					return new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			default:
				throw new Error(String.format("Browser '%s' not supported", browser));
		}
	}

	public void tearDown() throws Exception {
	    driver.quit();
	}

	public void initialize(String baseUrl) throws Exception {
	    WebDriver webDriver = getWebDriver();
	    if( !webDriver.getCurrentUrl().equals(baseUrl) ) {
			webDriver.get(baseUrl);
	    }
	}
	
}
