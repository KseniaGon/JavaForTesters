package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import com.example.framework.Contact;
import com.example.utils.SortedListOf;

public class ContactModificationTests extends ContactTestsBase {

	public ContactModificationTests() throws IOException {
		super();
	}

	@Test(dataProvider = "randomDataProvider")
	public void updateContact(Contact contact) {
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

	@Test()
	public void verifyContactDetails() {
		SortedListOf<Contact> oldList = getContacts();
		
		int index = getRandomValue(oldList.size()-1);
		Contact contact = applicationManager.getContactHelper().getContactDetails(index);
		
		assertThat(oldList.get(index), equalTo(contact));
	}
}
