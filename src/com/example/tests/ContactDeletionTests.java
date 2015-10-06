package com.example.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

	@Test
	public void DeleteContact() {
		this.applicationManager.deleteContact(1);		
	}
}
