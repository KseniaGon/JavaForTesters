package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.tests.helpers.Contact;

public class ContactDeletionTests extends TestBase {

	@Test
	public void DeleteContact() {
		List<Contact> oldList = this.applicationManager.getContacts();
		
		int index = 1;
		this.applicationManager.deleteContact(index);
		oldList.remove(index);
		
		assertEquals(oldList, this.applicationManager.getContacts());		
	}
}
