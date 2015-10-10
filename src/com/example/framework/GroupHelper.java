package com.example.framework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GroupHelper extends HelperBase {
	private static List<Group> cache;
	
	public GroupHelper(DriverManager driverManager) {
		super(driverManager);
	}

	public void create(Group group) {
		clickByName("new");
		fillForm(group);

		try {
			clickByName("submit");
		}
		finally {
			invaldateCache();
		}

	}

	public void delete(int index) {
		selectGroup(index);

		try{
			clickByName("delete");
		}
		finally {
			invaldateCache();
		}
	}


	public void update(int index, Group group) {
		selectGroup(index);
		clickByName("edit");
		fillForm(group);
		
		try {
			clickByName("update");
		}
		finally {
			invaldateCache();
		}
	}

	public List<Group> getGroups() {
		if( cache==null ) {
			cache = ensureGroups();
		}
		return cache;
	}

	protected void invaldateCache() {
		cache = null;
	}

	protected void fillForm(Group group) {
		fillInput("group_name", group.name);
		fillInput("group_header", group.header);
		fillInput("group_footer", group.footer);
	}

	protected List<Group> ensureGroups() {
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

	protected void selectGroup(int index) {
		findElementBy(By.xpath(String.format("//input[@name='selected[]'][%d]", index+1))).click();
	}

	
}
