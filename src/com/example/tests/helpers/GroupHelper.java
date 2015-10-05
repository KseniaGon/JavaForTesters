package com.example.tests.helpers;

import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {
	public GroupHelper(DriverManager driverManager) {
		super(driverManager);
	}

	public void create(Group group) {
		findElementByName("new").click();
		fillForm(group);
		findElementByName("submit").click();
	}

	protected void fillForm(Group group) {
		fillInput("group_name", group.name);
		fillInput("group_header", group.header);
		fillInput("group_footer", group.footer);
	}

	public void delete(int index) {
		selectGroup(index);
		findElementByName("delete").click();
	}

	protected void selectGroup(int index) {
		findElementBy(By.xpath(String.format("//input[@name='selected[]'][%d]", index))).click();
	}

	public void update(int index, Group group) {
		selectGroup(index);
		findElementByName("edit").click();
		fillForm(group);
		findElementByName("update").click();
	}
}
