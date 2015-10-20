package com.example.generators;

import java.util.ArrayList;
import java.util.List;

import com.example.framework.Contact;

public class RandomContactsGenerator extends BaseRandomGenerator {
	public List<Contact> getRandomData() {
		return getRandomData(5);		
	}

	public List<Contact> getRandomData(int count) {
		List<Contact> result = new ArrayList<Contact>();

		for(int i=0; i<count; i++) {
			Contact contact = 
				new Contact(
					generateRandomString("firstName"),
					generateRandomString("lastName"),
					generateRandomString("address"),
					"1234567890",
					"1234567890",
					"tet1@test1.test",
					"3",
					"February",
					"1980",
					null);
			
			result.add(contact);
		}

		return result;
	}	
}
