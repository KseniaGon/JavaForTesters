package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Group;

public class GroupModificationTests extends GroupTestsBase {

	@Test
	public void UpdateGroup() {
		List<Group> oldList = this.getGroups();

		int index = 0;

		Group group = new Group();
		group.name = "New name";

		this.applicationManager.getNavigationHelper().navigateTo("groups");
		this.applicationManager.getGroupHelper().update(index, group);

		oldList.remove(index);
		oldList.add(index, group);

		assertEquals(oldList, this.getGroups());

	}
}