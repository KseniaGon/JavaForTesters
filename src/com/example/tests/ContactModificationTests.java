package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Contact;

public class ContactModificationTests extends TestBase {

	@Test
	public void UpdateContact() {
		List<Contact> oldList = this.applicationManager.getContacts();
		
		Contact contact = new Contact();
		contact.firstName = "Updated first name";
		contact.lastName = "Updated last name";
		
		int index = 0;
		this.applicationManager.updateContact(index, contact);
		
		oldList.remove(index);
		oldList.add(contact);
		oldList.sort(null);
		
		assertEquals(oldList, this.applicationManager.getContacts());			
	}
}
