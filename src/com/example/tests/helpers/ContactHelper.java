package com.example.tests.helpers;

public class ContactHelper extends HelperBase {
	
	public ContactHelper(DriverManager driverManager) {
		super(driverManager);
	}

	public void create(Contact contact) {
		findElementByLinkText("add new").click();
		fillInput("firstname", contact.firstName);
		fillInput("lastname", contact.lastName);
		fillInput("address", contact.address);
		fillInput("home", contact.homePhone);
		fillInput("mobile", contact.mobilePhone);
		fillInput("email", contact.email);
	    selectByVisibleText("bday", contact.birthDay);
	    selectByVisibleText("bmonth", contact.birthMonth);
	    fillInput("byear", contact.birthYear);
	    selectByVisibleText("new_group", contact.groupName);
	    findElementByName("submit").click();
	}

}
