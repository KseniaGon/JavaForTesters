package com.example.tests;

import org.testng.annotations.Test;

import com.example.tests.helpers.Group;

public class GroupModificationTests extends TestBase {

	@Test
	public void UpdateGroup() {
		Group group = new Group();
		group.name = "New name";
		this.applicationManager.updateGroup(1, group);
		
	}
}
