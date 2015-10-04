package com.example.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import com.example.tests.helpers.DriverManager;

public class TestBase {

	protected WebDriver driver;
	private String baseUrl;
	private DriverManager driverManager;
	
	public TestBase() {
		this.driverManager = new DriverManager();
		this.baseUrl = "http://localhost";
	}

	@BeforeMethod
	public void setUp() throws Exception {
	    this.driver = this.driverManager.getWebDriver();
	    this.driver.get(this.baseUrl + "/addressbookv4.1.4/");
	  }

	@AfterSuite
	public void tearDown() throws Exception {
		this.driverManager.tearDown();
	}

	protected String getWellKnownGroupName() {
		return "test 1";
	}

}