package com.example.tests.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ApplicationManager {
	private String baseUrl;
	private DriverManager driverManager;

	public ApplicationManager(String baseUrl) {
		this.driverManager = new DriverManager();
		this.baseUrl = baseUrl;
	}
	protected WebDriver driver;
	
	public void setUp() throws Exception {
	    this.driver = this.driverManager.getWebDriver();
	    this.driver.get(this.baseUrl + "/addressbookv4.1.4/");
	}
	
	public void suiteTearDown() throws Exception {
		this.driverManager.tearDown();
	}
	
	public void createGroup(Group group) {
		driver.findElement(By.linkText("groups")).click();
	    driver.findElement(By.name("new")).click();
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	    driver.findElement(By.name("submit")).click();
	}

	public void createContact(Contact contact) {
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
