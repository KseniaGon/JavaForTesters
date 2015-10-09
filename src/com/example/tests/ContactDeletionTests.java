package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Contact;

public class ContactDeletionTests extends ContactTestsBase {

	@Test
	public void DeleteContact() {
		List<Contact> oldList = this.getContacts();
		
		int index = this.getRandomValue(oldList.size()-1);
		this.applicationManager.getNavigationHelper().navigateTo("home");
		this.applicationManager.getContactHelper().delete(index);

		oldList.remove(index);
		
		assertEquals(oldList, this.getContacts());		
	}
}
