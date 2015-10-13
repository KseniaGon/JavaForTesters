package com.example.tests;

import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.example.framework.ApplicationManager;

public class TestBase {

	protected ApplicationManager applicationManager;
			

	public TestBase() {
		applicationManager = new ApplicationManager("http://localhost");
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
	
	protected String generateRandomString(String prefix) {
		Random random = new Random();
		int i = random.nextInt(3);
		if( i==0 ) {
			return "";
		}
		return String.format("%s%d", prefix, random.nextInt());
	}


}