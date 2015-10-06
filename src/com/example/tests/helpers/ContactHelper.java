package com.example.tests.helpers;

import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {
	
	public ContactHelper(DriverManager driverManager) {
		super(driverManager);
	}

	public void create(Contact contact) {
		findElementByLinkText("add new").click();
		fillForm(contact);
	    findElementByName("submit").click();
	}
	
	public void update(int index, Contact contact) {
		selectContact(index);
		fillForm(contact);
		findElementBy(By.xpath("//input[@value='Update'][@name='update']")).click();
	}

	public void delete(int index) {
		selectContact(index);
		findElementBy(By.xpath("//input[@value='Delete'][@name='update']")).click();
	}

	private void selectContact(int index) {
		String selector = String.format("//table[@id='maintable']/tbody/tr[%d]/td[7]/a", index+1);
		findElementBy(By.xpath(selector)).click();
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
}
