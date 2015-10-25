package com.example.framework;

import java.util.List;

import com.example.utils.SortedListOf;

public class ContactsModel {
	private SortedListOf<Contact> cache;
	private boolean isModelValid = false;

	public ContactsModel() {
		cache = new SortedListOf<Contact>();
	}

	public boolean isValid() {
		return isModelValid;
	}
	
	public void fill(List<Contact> contacts) {
		cache = new SortedListOf<>(contacts);
		isModelValid = true;
	}
	
	public SortedListOf<Contact> getItems() {
		if( isValid()) {
			return new SortedListOf<Contact>(cache);
		}
		throw new Error("Invalid model");
	}

	public void addElement(Contact contact) {
		cache.add(contact);
	}

	public void replaceElement(int index, Contact contact) {
		cache = cache.withDeleted(index);
		cache.add(contact);
	}

	public void deleteElement(int index) {
		cache = cache.withDeleted(index);
	}

	public void invalidate() {
		isModelValid = false;
	}	
}
