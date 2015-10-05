package com.example.tests.helpers;

import org.openqa.selenium.WebDriver;

public class ApplicationManager {
	private String baseUrl;
	private DriverManager driverManager;
	private ContactHelper contactHelper;
	private GroupHelper groupHelper;
	private NavigationHelper navigationHelper;

	public ApplicationManager(String baseUrl) {
		this.driverManager = new DriverManager();
		this.baseUrl = baseUrl;
	}
	protected WebDriver driver;
	
	public void setUp() throws Exception {
	    this.driver = this.driverManager.getWebDriver();
	    this.driver.get(this.baseUrl + "/addressbookv4.1.4/");
	}
	
	public void suiteTearDown() throws Exception {
		this.driverManager.tearDown();
	}
	
	public void createGroup(Group group) {
		getNavigationHelper().navigateTo("groups");
	    getGroupHelper().create(group);
	}

	public void updateGroup(int index, Group group) {
		getNavigationHelper().navigateTo("groups");
	    getGroupHelper().update(index, group);
	}

	public void deleteGroup(int index) {
		getNavigationHelper().navigateTo("groups");
	    getGroupHelper().delete(index);
	}

	public void createContact(Contact contact) {
		getNavigationHelper().navigateTo("add new");
		getContactHelper().create(contact);
	}

	
	private GroupHelper getGroupHelper() {
		if(this.groupHelper==null) {
			this.groupHelper = new GroupHelper(this.driverManager);
		}
		return this.groupHelper;
	}

	private ContactHelper getContactHelper() {
		if(this.contactHelper==null) {
			this.contactHelper = new ContactHelper(this.driverManager);
		}
		return this.contactHelper;
	}

	private NavigationHelper getNavigationHelper() {
		if(this.navigationHelper==null) {
			this.navigationHelper = new NavigationHelper(this.driverManager);
		}
		return this.navigationHelper;
	}

}