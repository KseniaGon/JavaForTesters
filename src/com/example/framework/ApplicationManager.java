package com.example.framework;

public class ApplicationManager {
	private DriverManager driverManager;
	private ContactHelper contactHelper;
	private GroupHelper groupHelper;
	private NavigationHelper navigationHelper;

	public ApplicationManager(String baseUrl) {
		this.driverManager = new DriverManager(baseUrl);
	}

	public void setUp() throws Exception {
		this.driverManager.setUp();
	}

	public void suiteTearDown() throws Exception {
		this.driverManager.tearDown();
	}

	public GroupHelper getGroupHelper() {
		if(this.groupHelper==null) {
			this.groupHelper = new GroupHelper(this.driverManager);
		}
		return this.groupHelper;
	}

	public ContactHelper getContactHelper() {
		if(this.contactHelper==null) {
			this.contactHelper = new ContactHelper(this.driverManager);
		}
		return this.contactHelper;
	}

	public NavigationHelper getNavigationHelper() {
		if(this.navigationHelper==null) {
			this.navigationHelper = new NavigationHelper(this.driverManager);
		}
		return this.navigationHelper;
	}

}
