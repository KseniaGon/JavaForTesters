package com.example.tests.helpers;

public class NavigationHelper extends HelperBase {
	public NavigationHelper(DriverManager driverManager) {
		super(driverManager);
	}
	
	public void navigateTo(String name) {
		findElementByLinkText(name).click();
	}
}
