package com.example.tests.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {

	protected WebDriver driver;
	protected DriverManager driverManager;

	public HelperBase() {
		super();
	}

	public HelperBase(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	protected WebElement findElementByLinkText(String linkText) {
		return this.driverManager.getWebDriver().findElement(By.linkText(linkText));
	}
	
	protected WebElement findElementByName(String elementName) {
		return this.driverManager.getWebDriver().findElement(By.name(elementName));
	}
	
	protected void fillInput(String elementName, String value) {
		findElementByName(elementName).clear();
		findElementByName(elementName).sendKeys(value);
	}

	protected void selectByVisibleText(String elementName, String text) {
		new Select(this.driverManager.getWebDriver().findElement(By.name(elementName))).selectByVisibleText(text);
	}
	
}