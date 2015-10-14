package com.example.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	private static SortedListOf<Contact> cache;

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

	public SortedListOf<Contact> getContacts() {
		if( cache==null ) {
			cache = ensureContacts();
		}
		return cache;
	}

	private void invalidateCache() {
		cache = null;
	}

	private SortedListOf<Contact> ensureContacts() {
		List<WebElement> firstNames = findElementsBy(By.xpath("//table[@id='maintable']/tbody/tr/td[2]"));
		List<WebElement> lastNames = findElementsBy(By.xpath("//table[@id='maintable']/tbody/tr/td[3]"));
		SortedListOf<Contact> contacts = new SortedListOf<Contact>();

		int rowCount = getCountExcludingSelectAllRow(lastNames);
		
		for (int i = 0; i < rowCount; i++) {
			Contact contact = new Contact();
			contact.lastName = getText(lastNames.get(i));
			contact.firstName = getText(firstNames.get(i));

			contacts.add(contact);
		}
		return contacts;
	}

	private int getCountExcludingSelectAllRow(List<WebElement> lastNames) {
		int size = lastNames.size();
		if(size>1) {
			size--; // "Select all" row
		}
		return size;
	}

	private void selectContact(int index) {
		findElementBy(By.xpath(getCellXPath(index, 7) + "/a")).click();
	}

	private void fillForm(Contact contact) {
		// First Name and Last Name are swapped in Contact table (Home page)
		// If you rely on checkbox ID -- it is fine, if you relay on values in table, you should swap these values
		fillInput("firstname", contact.lastName);
		fillInput("lastname", contact.firstName);
		
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