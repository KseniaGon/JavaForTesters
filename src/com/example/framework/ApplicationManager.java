package com.example.framework;

public class ApplicationManager {
	private DriverManager driverManager;
	private ContactHelper contactHelper;
	private GroupHelper groupHelper;
	private CardsHelper cardsHelper;
	
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
			groupHelper = new GroupHelper(driverManager, getNavigationHelper(applicationBaseUrl));
		}
		return groupHelper;
	}

	public ContactHelper getContactHelper() {
		if(contactHelper==null) {
			contactHelper = new ContactHelper(driverManager, getNavigationHelper( applicationBaseUrl));
		}
		return contactHelper;
	}

	private NavigationHelper getNavigationHelper(String  applicationBaseUrl) {
		return new NavigationHelper(driverManager, applicationBaseUrl);
	}
	
	public CardsHelper getCardsHelper() {
		if(cardsHelper==null) {
			cardsHelper = new CardsHelper(driverManager, getNavigationHelper(applicationBaseUrl));
		}
		return cardsHelper;
	}	
}
