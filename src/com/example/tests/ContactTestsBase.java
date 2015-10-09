package com.example.tests;

import java.util.List;

import com.example.framework.Contact;

public class ContactTestsBase extends TestBase {

	protected List<Contact> getContacts() {
		this.applicationManager.getNavigationHelper().navigateTo("home");
		return this.applicationManager.getContactHelper().getContacts();
	}

}
