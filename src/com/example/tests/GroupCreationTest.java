package com.example.tests;

import org.testng.annotations.Test;

import com.example.tests.helpers.Group;

import org.openqa.selenium.*;

public class GroupCreationTest extends TestBase {
  @Test
  public void createGroup() throws Exception {
	Group group = getGroupTestData();
	createGroupInternal(group);
  }

  @Test
  public void createGroupWithMultiLineFooter() throws Exception {
	Group group = getGroupTestData();
	group.footer = "Test \n\r Footer";
	createGroupInternal(group);
  }
  
	private Group getGroupTestData() {
		return new Group(getWellKnownGroupName(), "test header", "test footer");
	}
	
	private void createGroupInternal(Group group) {
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
}
