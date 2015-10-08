package com.example.tests;

import java.util.List;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.example.tests.helpers.Contact;

public class ContactCreateTest extends TestBase {
	@Test
	public void createContact() throws Exception {
		List<Contact> oldList = this.applicationManager.getContacts();
		
		Contact contact = getTestContactData(getWellKnownGroupName());
		this.applicationManager.createContact(contact);
		
		oldList.add(contact);
		oldList.sort(null);
		
		List<Contact> newList = this.applicationManager.getContacts();
		assertEquals(oldList, newList);
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
