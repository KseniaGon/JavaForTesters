package com.example.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	private static SortedListOf<Contact> cache;

	public ContactHelper(DriverManager driverManager, NavigationHelper navigationHelper) {
		super(driverManager, navigationHelper);
	}

	public void create(Contact contact) {
		selectNew()
			.fillForm(contact);

		try {
			clickByName("submit");
		}
		finally {
			invalidateCache();
		}
	}

	public void update(int index, Contact contact) {
		navigateTo().home();

		selectContact(index)
			.fillForm(contact);

		try {
			clickOnUpdate();
		}
		finally {
			invalidateCache();
		}
	}

	public void delete(int index) {
		navigateTo().home();

		selectContact(index);
		
		try{
			clickOnDelete();
		}
		finally {
			invalidateCache();
		}
	}

	public SortedListOf<Contact> getContacts() {
		navigateTo().home();
		
		if( cache==null ) {
			cache = ensureContacts();
		}
		return cache;
	}

	public SortedListOf<Card> convertToCards(SortedListOf<Contact> contacts) {
		SortedListOf<Card> result = new SortedListOf<Card>();
		
		for(Contact contact: contacts) {
			result.add(
				new Card()
					.withFirstAndLastName(getFirstAndLastName(contact))
					.withPhone(contact.getHomePhone()));
		}
		return result;
	}

	private void invalidateCache() {
		cache = null;
	}

	private SortedListOf<Contact> ensureContacts() {
		List<WebElement> firstNames = findElementsBy(By.xpath("//table[@id='maintable']/tbody/tr/td[2]"));
		List<WebElement> lastNames = findElementsBy(By.xpath("//table[@id='maintable']/tbody/tr/td[3]"));
		List<WebElement> phones = findElementsBy(By.xpath("//table[@id='maintable']/tbody/tr/td[5]"));
		SortedListOf<Contact> contacts = new SortedListOf<Contact>();

		int rowCount = getCountExcludingSelectAllRow(lastNames);
		
		for (int i = 0; i < rowCount; i++) {
			contacts.add(
				new Contact()
					 .withLastName(getText(lastNames.get(i)))
					 .withfirstName(getText(firstNames.get(i)))
					 .withPhone(getText(phones.get(i))));
		}
		return contacts;
	}

	private int getCountExcludingSelectAllRow(List<WebElement> lastNames) {
		return lastNames.size() - 1; // "Select all" row
	}

	private ContactHelper selectContact(int index) {
		findElementBy(By.xpath(getCellXPath(index, 7) + "/a")).click();
		return this;
	}

	private void fillForm(Contact contact) {
		// First Name and Last Name are swapped in Contact table (Home page)
		// If you rely on checkbox ID -- it is fine, if you relay on values in table, you should swap these values
		fillInput("firstname", contact.getLastName())
			.fillInput("lastname", contact.getFirstName())
			.fillInput("address", contact.getAddress())
			.fillInput("home", contact.getHomePhone())
			.fillInput("mobile", contact.getMobilePhone())
			.fillInput("email", contact.getEmail())
			.selectByVisibleText("bday", contact.getBirthDay())
			.selectByVisibleText("bmonth", contact.getBirthMonth())
			.fillInput("byear", contact.getBirthYear())
			.selectByVisibleText("new_group", contact.getGroupName());
	}

	private String getCellXPath(int row, int position) {
		return String.format("//table[@id='maintable']/tbody/tr[%d]/td[%d]", row+2, position);
	}

	private ContactHelper selectNew() {
		findElementByLinkText("add new").click();
		return this;
	}

	private void clickOnUpdate() {
		clickByXPath("//input[@value='Update'][@name='update']");
	}

	private void clickOnDelete() {
		clickByXPath("//input[@value='Delete'][@name='update']");
	}

	private String getFirstAndLastName(Contact contact) {
		String firstName = contact.getFirstName();
		String lastName = contact.getLastName();
		
		if( firstName==null || firstName.isEmpty() ) {
			return lastName;
		}
		else if( lastName==null ||  lastName.isEmpty() ) {
			return firstName;
		}
		else {
			return String.format("%s %s", lastName, firstName);
		}
	}
}