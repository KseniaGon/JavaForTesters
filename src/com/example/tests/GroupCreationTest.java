package com.example.tests;

import java.util.List;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.example.framework.ApplicationManager;
import com.example.framework.Group;

public class GroupCreationTest extends GroupTestsBase {

	@Test(dataProvider = "randomDataProvider")
	public void createGroup(Group group) throws Exception {
		List<Group> oldList = this.getGroups();

		this.applicationManager.getNavigationHelper().navigateTo("groups");
		this.applicationManager.getGroupHelper().create(group);

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
