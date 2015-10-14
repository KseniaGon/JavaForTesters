package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Group;

public class GroupModificationTests extends GroupTestsBase {

	@Test(dataProvider = "randomDataProvider")
	public void UpdateGroup(Group group) {
		List<Group> oldList = getGroups();

		int index = getRandomValue(oldList.size()-1);
		applicationManager.getNavigationHelper().groups();
		applicationManager.getGroupHelper().update(index, group);

		oldList.remove(index);
		oldList.add(index, group);
		oldList.sort(null);

		assertEquals(oldList, getGroups());

	}
}