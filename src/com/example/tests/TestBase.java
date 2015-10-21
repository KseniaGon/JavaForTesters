package com.example.tests;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.example.framework.ApplicationManager;

public class TestBase {

	protected ApplicationManager applicationManager;
			

	public TestBase() throws IOException {
		Properties properties = new Properties();
		Reader reader = new FileReader(System.getProperty("configFile", "firefox.properties"));
		properties.load(reader);
		reader.close();
		
		applicationManager = new ApplicationManager(properties);
		
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