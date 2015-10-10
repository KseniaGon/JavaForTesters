package com.example.framework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactHelper extends HelperBase {
	private static List<Contact> cache;

	public ContactHelper(DriverManager driverManager) {
		super(driverManager);
	}

	public void create(Contact contact) {
		findElementByLinkText("add new").click();
		fillForm(contact);

		try {
			clickByName("submit");
		}
		finally {
			invalidateCache();
		}
	}

	public void update(int index, Contact contact) {
		selectContact(index);
		fillForm(contact);

		try {
			clickByXPath("//input[@value='Update'][@name='update']");
		}
		finally {
			invalidateCache();
		}
	}

	public void delete(int index) {
		selectContact(index);
		try{
			clickByXPath("//input[@value='Delete'][@name='update']");
		}
		finally {
			invalidateCache();
		}
	}

	public List<Contact> getContacts() {
		if( cache==null ) {
			cache = ensureContacts();
		}
		return cache;
	}

	private void invalidateCache() {
		cache = null;
	}

	private List<Contact> ensureContacts() {
		List<WebElement> elements = findElementsBy(By.xpath("//input[@name='selected[]']"));
		List<Contact> contacts = new ArrayList<Contact>();

		for (int i = 0; i < elements.size(); i++) {
			Contact contact = new Contact();
			contact.lastName = findElementBy(By.xpath(getCellXPath(i, 2))).getText();
			contact.firstName = findElementBy(By.xpath(getCellXPath(i, 3))).getText();

			contacts.add(contact);
		}
		return contacts;
	}

	private void selectContact(int index) {
		findElementBy(By.xpath(getCellXPath(index, 7) + "/a")).click();
	}

	private void fillForm(Contact contact) {
		fillInput("firstname", contact.firstName);
		fillInput("lastname", contact.lastName);
		fillInput("address", contact.address);
		fillInput("home", contact.homePhone);
		fillInput("mobile", contact.mobilePhone);
		fillInput("email", contact.email);
		selectByVisibleText("bday", contact.birthDay);
		selectByVisibleText("bmonth", contact.birthMonth);
		fillInput("byear", contact.birthYear);
		selectByVisibleText("new_group", contact.groupName);
	}

	private String getCellXPath(int row, int position) {
		return String.format("//table[@id='maintable']/tbody/tr[%d]/td[%d]", row+2, position);
	}
}