package com.example.tests;

import java.util.List;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.example.framework.Contact;

public class ContactCreateTest extends ContactTestsBase {
	
	@Test(dataProvider = "randomDataProvider")
	public void createContact(Contact contact) throws Exception {
		List<Contact> oldList = getContacts();
		
		contact.groupName = getWellKnownGroupName();

		applicationManager.getNavigationHelper().addNewContact();
		applicationManager.getContactHelper().create(contact);
		
		oldList.add(contact);
		oldList.sort(null);
		
		List<Contact> newList = getContacts();
		assertEquals(oldList, newList);
	}
}
