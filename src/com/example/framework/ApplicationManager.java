package com.example.framework;

public class ApplicationManager {
	private DriverManager driverManager;
	private ContactHelper contactHelper;
	private GroupHelper groupHelper;
	private NavigationHelper navigationHelper;

	public ApplicationManager(String baseUrl) {
		driverManager = new DriverManager(baseUrl);
	}

	public void setUp() throws Exception {
		driverManager.setUp();
	}

	public void suiteTearDown() throws Exception {
		driverManager.tearDown();
	}

	public GroupHelper getGroupHelper() {
		if(groupHelper==null) {
			groupHelper = new GroupHelper(driverManager);
		}
		return groupHelper;
	}

	public ContactHelper getContactHelper() {
		if(contactHelper==null) {
			contactHelper = new ContactHelper(driverManager);
		}
		return contactHelper;
	}

	public NavigationHelper getNavigationHelper() {
		if(navigationHelper==null) {
			navigationHelper = new NavigationHelper(driverManager);
		}
		return navigationHelper;
	}

}
