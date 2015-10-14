package com.example.framework;

public class NavigationHelper extends HelperBase {
	private String applicationBaseUrl;

	public NavigationHelper(DriverManager driverManager, String applicationBaseUrl) {
		super(driverManager);
		this.applicationBaseUrl = applicationBaseUrl;
	}
	
	public void home() {
		if( !isAtHome()) {
			navigateTo("home");
		}
	}
	
	public void groups() {
		if( !isAtGroups() ) {
			navigateTo("groups");
		}
	}
	
	public void addNewContact() {
		navigateTo("add new");
	}
	
	private void navigateTo(String name) {
		findElementByLinkText(name).click();
	}

	private boolean isAtHome() {
		//Query string support?
		return getCurrentUri().equals(applicationBaseUrl);
	}

	private boolean isAtGroups() {
		//???? Looks like absence of element is subject of timeout and there is no optimization with such check  
		//if( getCurrentUri().startsWith(applicationBaseUrl + "group.php") ) {
		//	return findElementsBy(By.name("new")).size()>0;
		//}
		return false;
	}
}
