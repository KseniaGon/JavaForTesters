package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Contact;

public class ContactModificationTests extends ContactTestsBase {

	@Test(dataProvider = "randomDataProvider")
	public void UpdateContact(Contact contact) {
		List<Contact> oldList = this.getContacts();
		
		int index = this.getRandomValue(oldList.size()-1);
		this.applicationManager.getNavigationHelper().navigateTo("home");
		this.applicationManager.getContactHelper().update(index, contact);
		
		oldList.remove(index);
		oldList.add(contact);
		oldList.sort(null);
		
		assertEquals(oldList, this.getContacts());			
	}
	
}
