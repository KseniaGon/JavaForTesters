package com.example.tests;

import java.util.List;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.example.framework.ApplicationManager;
import com.example.framework.Group;

public class GroupCreationTest extends GroupTestsBase {

	@Test
	public void createGroup() throws Exception {
		List<Group> oldList = this.getGroups();

		Group group = getGroupTestData();
		ApplicationManager r = this.applicationManager;
		r.getNavigationHelper().navigateTo("groups");
		r.getGroupHelper().create(group);

		oldList.add(group);
		oldList.sort(null);

		assertEquals(oldList, this.getGroups());
	}

	@Test
	public void createGroupWithMultiLineFooter() throws Exception {
		List<Group> oldList = this.getGroups();

		Group group = getGroupTestData();
		group.footer = "Test \n\r Footer";
		ApplicationManager r = this.applicationManager;
		r.getNavigationHelper().navigateTo("groups");
		r.getGroupHelper().create(group);

		oldList.add(group);
		oldList.sort(null);

		assertEquals(oldList, getGroups());
	}

	private Group getGroupTestData() {
		return new Group(getWellKnownGroupName(), "test header", "test footer");
	}
}
