package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Contact;

public class ContactDeletionTests extends ContactTestsBase {

	@Test
	public void DeleteContact() {
		List<Contact> oldList = getContacts();
		
		int index = getRandomValue(oldList.size()-1);
		applicationManager.getNavigationHelper().home();
		applicationManager.getContactHelper().delete(index);

		oldList.remove(index);
		
		assertEquals(oldList, getContacts());		
	}
}
