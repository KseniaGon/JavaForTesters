package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import com.example.framework.Contact;
import com.example.utils.SortedListOf;

public class ContactDeletionTests extends ContactTestsBase {

	public ContactDeletionTests() throws IOException {
		super();
	}

	@Test
	public void deleteContact() {
		SortedListOf<Contact> oldList = getContacts();
		
		int index = getRandomValue(oldList.size()-1);
		applicationManager.getContactHelper().delete(index);

		assertThat(getContacts(), equalTo(oldList.withDeleted(index)));		
	}
}
