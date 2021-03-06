package com.example.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {

	private DriverManager driverManager;
	private NavigationHelper navigationHelper;

	public HelperBase(DriverManager driverManager, NavigationHelper navigationHelper) {
		this.driverManager = driverManager;
		this.navigationHelper = navigationHelper;
	}
	
	protected NavigationHelper navigateTo() {
		return navigationHelper;
	}


	protected WebElement findElementByLinkText(String linkText) {
		return findElementBy(By.linkText(linkText));
	}

	protected WebElement findElementByName(String elementName) {
		return findElementBy(By.name(elementName));
	}

	protected WebElement findElementBy(By locator) {
		return driverManager.getWebDriver().findElement(locator);
	}

	protected List<WebElement> findElementsBy(By locator) {
		return driverManager.getWebDriver().findElements(locator);
	}

	protected HelperBase fillInput(String elementName, String value) {
		if (value != null) {
			findElementByName(elementName).clear();
			findElementByName(elementName).sendKeys(value);
		}
		return this;
	}

	protected String getInputValue(String name) {
		return findElementByName(name).getAttribute("value");
	}
	
	protected HelperBase selectByVisibleText(String elementName, String text) {
		if (text != null) {
			new Select(driverManager.getWebDriver().findElement(By.name(elementName))).selectByVisibleText(text);
		}
		return this;
	}

	protected void clickByName(String name) {
		findElementByName(name).click();
	}

	protected void clickByXPath(String xPathExpression) {
		findElementBy(By.xpath(xPathExpression)).click();
	}

	protected String getText(WebElement element) {
		return element.getText();
		// https://code.google.com/p/selenium/issues/detail?id=4905
		// return
		// (String)((JavascriptExecutor)driverManager.getWebDriver())
		// .executeScript("return arguments[0].innerText ||
		// arguments[0].textContent;", element);
	}
	
	protected String getCurrentUri() {
		//TODO: return URI
		return this.driverManager.getWebDriver().getCurrentUrl();
	}
}