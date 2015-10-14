package com.example.framework;

public class ApplicationManager {
	private DriverManager driverManager;
	private ContactHelper contactHelper;
	private GroupHelper groupHelper;
	private NavigationHelper navigationHelper;
	private String applicationBaseUrl;

	public ApplicationManager(String applicationBaseUrl) {
		driverManager = new DriverManager();
		this.applicationBaseUrl = applicationBaseUrl;
	}

	public void setUp() throws Exception {
		driverManager.initialize(applicationBaseUrl);
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

	public NavigationHelper navigateTo() {
		if(navigationHelper==null) {
			navigationHelper = new NavigationHelper(driverManager, applicationBaseUrl);
		}
		return navigationHelper;
	}

}
