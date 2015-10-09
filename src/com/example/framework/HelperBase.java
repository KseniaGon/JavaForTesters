package com.example.framework;

import java.util.List;

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
		return findElementBy(By.linkText(linkText));
	}

	protected WebElement findElementByName(String elementName) {
		return findElementBy(By.name(elementName));
	}

	protected WebElement findElementBy(By locator) {
		return this.driverManager.getWebDriver().findElement(locator);
	}

	protected List<WebElement> findElementsBy(By locator) {
		return this.driverManager.getWebDriver().findElements(locator);
	}

	protected void fillInput(String elementName, String value) {
		if(value!=null) {
			findElementByName(elementName).clear();
			findElementByName(elementName).sendKeys(value);
		}
	}

	protected void selectByVisibleText(String elementName, String text) {
		if( text!=null) {
			new Select(this.driverManager.getWebDriver().findElement(By.name(elementName))).selectByVisibleText(text);
		}
	}

}