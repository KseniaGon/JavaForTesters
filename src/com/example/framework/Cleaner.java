package com.example.framework;

public class Cleaner {
	
	public static void main(String[] args) throws Exception {
		ApplicationManager applicationManager =  new ApplicationManager("http://localhost/addressbookv4.1.4/");
		applicationManager.setUp();
		
		int contactsCount = applicationManager.getContactHelper().getContacts().size();
		for( int i=10; i<contactsCount; i++ ) {
			applicationManager.getContactHelper().delete(0);
		}

		int groupsCount = applicationManager.getGroupHelper().getGroups().size();
		for( int i=10; i<groupsCount; i++ ) {
			applicationManager.getGroupHelper().delete(0);
		}
		
		applicationManager.suiteTearDown();
	}

}
