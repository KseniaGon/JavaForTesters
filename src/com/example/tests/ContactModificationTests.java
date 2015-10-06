package com.example.tests;

import org.testng.annotations.Test;

import com.example.tests.helpers.Contact;

public class ContactModificationTests extends TestBase {

	@Test
	public void UpdateContact() {
		Contact contact = new Contact();
		contact.firstName = "Updated first name";
		this.applicationManager.updateContact(1, contact);
	}
}
