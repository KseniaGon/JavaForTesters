package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.tests.helpers.Group;

public class GroupModificationTests extends TestBase {

	@Test
	public void UpdateGroup() {
		List<Group> oldList = this.applicationManager.getGroups();

		int index = 0;

		Group group = new Group();
		group.name = "New name";
		this.applicationManager.updateGroup(index, group);

		oldList.remove(index);
		oldList.add(index, group);

		assertEquals(oldList, this.applicationManager.getGroups());

	}
}