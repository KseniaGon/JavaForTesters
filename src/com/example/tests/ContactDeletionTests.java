package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import com.example.framework.Contact;
import com.example.utils.SortedListOf;

public class ContactDeletionTests extends ContactTestsBase {

	@Test
	public void DeleteContact() {
		SortedListOf<Contact> oldList = getContacts();
		
		int index = getRandomValue(oldList.size()-1);
		applicationManager.navigateTo().home();
		applicationManager.getContactHelper().delete(index);

		assertThat(getContacts(), equalTo(oldList.withDeleted(index)));		
	}
}
