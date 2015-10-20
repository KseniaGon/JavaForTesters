package com.example.generators;

import com.example.framework.Contact;

public class ContactFileReader extends FileReaderBase<Contact> {
	@Override
	protected Class<Contact> getClassDefinition() {
		return Contact.class;
	}

	@Override
	protected String getFileName() {
		return "contacts.xml";
	}

	protected String getAliasName() {
		return "contact";
	}

}
