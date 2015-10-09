package com.example.framework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		findElementBy(By.xpath(String.format("//input[@name='selected[]'][%d]", index+1))).click();
	}

	public void update(int index, Group group) {
		selectGroup(index);
		findElementByName("edit").click();
		fillForm(group);
		findElementByName("update").click();
	}


	public List<Group> getGroups() {
		List<WebElement> elements = findElementsBy(By.xpath("//input[@name='selected[]']"));
		List<Group> groups = new ArrayList<Group>();

		for (int i = 0; i < elements.size(); i++) {
			WebElement element = elements.get(i);

			Group group = new Group();
			//<input name="selected[]" value="3" title="Select (test 1)" type="checkbox">test 1<br>
			group.name = element.getAttribute("title").replaceAll("Select \\((.*)\\)", "$1");

			groups.add(group);		}
		return groups;
	}

}
