package com.example.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {
	private static SortedListOf<Group> cache;
	
	public GroupHelper(DriverManager driverManager, NavigationHelper navigationHelper) {
		super(driverManager, navigationHelper);
	}

	public void create(Group group) {
		selectNew()
			.fillForm(group);

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
		navigateTo().groups();
	}


	public void update(int index, Group group) {
		selectGroup(index)
			.selectEdit()
			.fillForm(group);
		
		try {
			clickByName("update");
		}
		finally {
			invaldateCache();
		}
	}

	public SortedListOf<Group> getGroups() {
		navigateTo().groups();
		
		if( cache==null ) {
			cache = ensureGroups();
		}
		return cache;
	}

	protected void invaldateCache() {
		cache = null;
	}

	protected void fillForm(Group group) {
		fillInput("group_name", group.getName())
			.fillInput("group_header", group.getHeader())
			.fillInput("group_footer", group.getFooter());
	}

	protected SortedListOf<Group> ensureGroups() {
		List<WebElement> elements = findElementsBy(By.xpath("//input[@name='selected[]']"));
		SortedListOf<Group> groups = new SortedListOf<Group>();

		int rowsCount = elements.size();
		for (int i = 0; i < rowsCount; i++) {
			WebElement element = elements.get(i);

			//<input name="selected[]" value="3" title="Select (test 1)" type="checkbox">test 1<br>
			Group group = new Group()
					.withName(element.getAttribute("title").replaceAll("Select \\((.*)\\)", "$1"));

			groups.add(group);		}
		return groups;
	}

	protected GroupHelper selectGroup(int index) {
		findElementBy(By.xpath(String.format("//input[@name='selected[]'][%d]", index+1))).click();
		return this;
	}
	
	private GroupHelper selectEdit() {
		clickByName("edit");
		return this;
	}

	private GroupHelper selectNew() {
		clickByName("new");
		return this;
	}
}
