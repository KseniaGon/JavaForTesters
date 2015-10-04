package com.example.tests;

import org.testng.annotations.Test;

import com.example.tests.helpers.Contact;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ContactCreateTest extends TestBase {
  @Test
  public void createContact() throws Exception {
	Contact contact = getTestContactData(getWellKnownGroupName());
    createGroupInternal(contact);
  }

	private Contact getTestContactData(String groupName) {
		return new Contact(
			"firstName",
			"lastName",
			"address",
			"1234567890",
			"1234567890",
			"tet1@test1.test",
			"3",
			"February",
			"1980",
			groupName);
	}
	
	private void createGroupInternal(Contact contact) {
		driver.findElement(By.linkText("add new")).click();
	    driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(contact.firstName);
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(contact.lastName);
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(contact.address);
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(contact.homePhone);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(contact.mobilePhone);
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(contact.email);
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.birthDay);
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.birthMonth);
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(contact.birthYear);
	    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.groupName);
	    driver.findElement(By.name("submit")).click();
	}
}
