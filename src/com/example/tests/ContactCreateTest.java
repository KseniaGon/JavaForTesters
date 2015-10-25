package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;

import com.example.framework.Contact;
import com.example.utils.SortedListOf;

public class ContactCreateTest extends ContactTestsBase {
	
	public ContactCreateTest() throws IOException {
		super();
	}

	@Test(dataProvider = "randomDataProvider")
	public void createRandomContact(Contact contact) throws Exception {
		createContactInternal(contact);
	}

	@Test(dataProvider = "fileDataProvider")
	public void createContact(Contact contact) throws Exception {
		createContactInternal(contact);
	}

	private void createContactInternal(Contact contact) {
		SortedListOf<Contact> oldList = getContacts();
		
		contact = contact.withGroupName(getWellKnownGroupName());
		applicationManager.getContactHelper().create(contact);
		
		assertThat(getContacts(), equalTo(oldList.withAdded(contact)));
		applicationManager.getContactHelper().verifyConsistency();
	}
}
