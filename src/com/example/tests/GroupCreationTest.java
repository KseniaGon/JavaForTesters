package com.example.tests;

import java.util.List;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.example.tests.helpers.Group;

public class GroupCreationTest extends TestBase {

	@Test
	public void createGroup() throws Exception {
		List<Group> oldList = this.applicationManager.getGroups();

		Group group = getGroupTestData();
		this.applicationManager.createGroup(group);

		oldList.add(group);
		oldList.sort(null);

		assertEquals(oldList, this.applicationManager.getGroups());
	}

	@Test
	public void createGroupWithMultiLineFooter() throws Exception {
		List<Group> oldList = this.applicationManager.getGroups();

		Group group = getGroupTestData();
		group.footer = "Test \n\r Footer";
		this.applicationManager.createGroup(group);

		oldList.add(group);
		oldList.sort(null);

		assertEquals(oldList, this.applicationManager.getGroups());
	}

	private Group getGroupTestData() {
		return new Group(getWellKnownGroupName(), "test header", "test footer");
	}
}
