package com.example.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.example.framework.ApplicationManager;

public class TestBase {

	protected ApplicationManager applicationManager;
			

	public TestBase() {
		this.applicationManager = new ApplicationManager("http://localhost");
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		this.applicationManager.setUp();
	  }

	@AfterSuite
	public void tearDown() throws Exception {
		this.applicationManager.suiteTearDown();
	}

	protected String getWellKnownGroupName() {
		return "test 1";
	}


}