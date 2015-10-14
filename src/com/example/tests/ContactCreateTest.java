package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;

import com.example.framework.Contact;
import com.example.utils.SortedListOf;

public class ContactCreateTest extends ContactTestsBase {
	
	@Test(dataProvider = "randomDataProvider")
	public void createContact(Contact contact) throws Exception {
		SortedListOf<Contact> oldList = getContacts();
		
		contact.groupName = getWellKnownGroupName();
		applicationManager.getContactHelper().create(contact);
		
		assertThat(getContacts(), equalTo(oldList.withAdded(contact)));
	}
}
