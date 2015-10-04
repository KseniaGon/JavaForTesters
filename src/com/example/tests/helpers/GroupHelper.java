package com.example.tests.helpers;

public class GroupHelper extends HelperBase {
	public GroupHelper(DriverManager driverManager) {
		super(driverManager);
	}

	public void create(Group group) {
		findElementByName("new").click();
		fillInput("group_name", group.name);
		fillInput("group_header", group.header);
		fillInput("group_footer", group.footer);
		findElementByName("submit").click();
	}
}
