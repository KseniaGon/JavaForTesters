package com.example.framework;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class Cleaner {
	
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		Reader reader = new FileReader("firefox.properties");
		properties.load(reader);
		reader.close();
		
		ApplicationManager applicationManager =  new ApplicationManager(properties);
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
