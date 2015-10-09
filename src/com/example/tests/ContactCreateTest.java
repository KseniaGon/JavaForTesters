package com.example.tests;

import java.util.List;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.example.framework.Contact;

public class ContactCreateTest extends ContactTestsBase {
	
	@Test(dataProvider = "randomDataProvider")
	public void createContact(Contact contact) throws Exception {
		List<Contact> oldList = this.getContacts();
		
		contact.groupName = getWellKnownGroupName();

		this.applicationManager.getNavigationHelper().navigateTo("add new");
		this.applicationManager.getContactHelper().create(contact);
		
		oldList.add(contact);
		oldList.sort(null);
		
		List<Contact> newList = this.getContacts();
		assertEquals(oldList, newList);
	}
}
