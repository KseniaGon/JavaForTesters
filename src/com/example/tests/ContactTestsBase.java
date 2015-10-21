package com.example.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.example.framework.Contact;
import com.example.generators.ContactFileReader;
import com.example.generators.RandomContactsGenerator;
import com.example.utils.SortedListOf;

public class ContactTestsBase extends TestBase {
	
	public ContactTestsBase() throws IOException {
		super();
	}

	@DataProvider
	protected Iterator<Object[]> randomDataProvider() {
		List<Object[]> result = new ArrayList<Object[]>();

		for(Contact contact: new RandomContactsGenerator().getRandomData(2) ) {
			result.add(new Object[] { contact  });
		}
		
		return result.iterator();		
	}

	@DataProvider
	protected Iterator<Object[]> fileDataProvider() {
		List<Object[]> result = new ArrayList<Object[]>();

		for(Contact contact: new ContactFileReader().read() ) {
			result.add(new Object[] { contact  });
		}
		
		return result.iterator();		
	}
	
	protected SortedListOf<Contact> getContacts() {
		return applicationManager.getContactHelper().getContacts();
	}

}
