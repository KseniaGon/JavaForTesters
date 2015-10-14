package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Contact;

public class ContactModificationTests extends ContactTestsBase {

	@Test(dataProvider = "randomDataProvider")
	public void UpdateContact(Contact contact) {
		List<Contact> oldList = getContacts();
		
		int index = getRandomValue(oldList.size()-1);
		applicationManager.getNavigationHelper().home();
		applicationManager.getContactHelper().update(index, contact);
		
		oldList.remove(index);
		oldList.add(contact);
		oldList.sort(null);
		
		assertEquals(oldList, getContacts());			
	}
	
}
