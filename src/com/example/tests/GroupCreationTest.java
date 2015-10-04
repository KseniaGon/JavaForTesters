package com.example.tests;

import org.testng.annotations.Test;

import com.example.tests.helpers.Group;

public class GroupCreationTest extends TestBase {
  @Test
  public void createGroup() throws Exception {
	Group group = getGroupTestData();
	this.applicationManager.createGroup(group);
  }

  @Test
  public void createGroupWithMultiLineFooter() throws Exception {
	Group group = getGroupTestData();
	group.footer = "Test \n\r Footer";
	this.applicationManager.createGroup(group);
  }
  
	private Group getGroupTestData() {
		return new Group(getWellKnownGroupName(), "test header", "test footer");
	}
}
