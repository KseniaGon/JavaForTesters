package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.example.framework.Contact;

public class ContactTestsBase extends TestBase {
	
	@DataProvider
	protected Iterator<Object[]> randomDataProvider() {
		List<Object[]> result = new ArrayList<Object[]>();

		for(int i=0; i<5; i++) {
			Contact contact = 
				new Contact(
					this.generateRandomString("firstName"),
					this.generateRandomString("lastName"),
					this.generateRandomString("address"),
					"1234567890",
					"1234567890",
					"tet1@test1.test",
					"3",
					"February",
					"1980",
					null);
			
			result.add(new Object[] { contact  });
		}

		return result.iterator();		
	}

	protected List<Contact> getContacts() {
		this.applicationManager.getNavigationHelper().navigateTo("home");
		return this.applicationManager.getContactHelper().getContacts();
	}

}
