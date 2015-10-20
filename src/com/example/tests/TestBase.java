package com.example.tests;

import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.example.framework.ApplicationManager;

public class TestBase {

	protected ApplicationManager applicationManager;
			

	public TestBase() {
		applicationManager = new ApplicationManager("http://localhost/addressbookv4.1.4/");
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		applicationManager.setUp();
	  }

	@AfterSuite
	public void tearDown() throws Exception {
		applicationManager.suiteTearDown();
	}

	protected String getWellKnownGroupName() {
		return "test 1";
	}

	protected int getRandomValue(int bound) {
		Random random = new Random();
		return random.nextInt(bound);
	}

}