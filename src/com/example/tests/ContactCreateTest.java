package com.example.tests;

import org.testng.annotations.Test;

import com.example.tests.helpers.Contact;

public class ContactCreateTest extends TestBase {
  @Test
  public void createContact() throws Exception {
	Contact contact = getTestContactData(getWellKnownGroupName());
	this.applicationManager.createContact(contact);
  }

	private Contact getTestContactData(String groupName) {
		return new Contact(
			"firstName",
			"lastName",
			"address",
			"1234567890",
			"1234567890",
			"tet1@test1.test",
			"3",
			"February",
			"1980",
			groupName);
	}
}
