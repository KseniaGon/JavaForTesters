package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import com.example.framework.Contact;
import com.example.utils.SortedListOf;

public class ContactModificationTests extends ContactTestsBase {

	@Test(dataProvider = "randomDataProvider")
	public void UpdateContact(Contact contact) {
		SortedListOf<Contact> oldList = getContacts();
		
		int index = getRandomValue(oldList.size()-1);
		applicationManager.getContactHelper().update(index, contact);
		
		assertThat(
				getContacts(), 
				equalTo(
					oldList
						.withDeleted(index)
						.withAdded(contact)));			
	}
	
}
