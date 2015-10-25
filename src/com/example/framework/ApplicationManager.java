package com.example.framework;

import java.util.Properties;

public class ApplicationManager {
	private DriverManager driverManager;
	private ContactHelper contactHelper;
	private GroupHelper groupHelper;
	private CardsHelper cardsHelper;
	
	private String applicationBaseUrl;
	private HibernateHelper hibernateHelper;
	private Properties properties;

	public ApplicationManager(Properties properties) {
		this.properties = properties;
		driverManager = new DriverManager(properties.getProperty("browser"));
		this.applicationBaseUrl = properties.getProperty("baseUrl");
	}

	public void setUp() throws Exception {
		driverManager.initialize(applicationBaseUrl);
	}

	public void suiteTearDown() throws Exception {
		driverManager.tearDown();
	}

	public GroupHelper getGroupHelper() {
		if(groupHelper==null) {
			groupHelper = new GroupHelper(driverManager, getNavigationHelper(applicationBaseUrl), getHibernateHelper());
		}
		return groupHelper;
	}

	private HibernateHelper getHibernateHelper() {
		if(hibernateHelper==null) {
			hibernateHelper = new HibernateHelper();
		}
		return hibernateHelper;
	}

	public ContactHelper getContactHelper() {
		if(contactHelper==null) {
			contactHelper = new ContactHelper(properties, driverManager, getNavigationHelper(applicationBaseUrl), getHibernateHelper());
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
