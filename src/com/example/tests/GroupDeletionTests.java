package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Group;

public class GroupDeletionTests extends GroupTestsBase {

	@Test
	public void DeleteGroup() {
		List<Group> oldList = getGroups();

		int index = getRandomValue(oldList.size()-1);
		applicationManager.getNavigationHelper().navigateTo("groups");
		applicationManager.getGroupHelper().delete(index);

		oldList.remove(index);

		assertEquals(oldList, getGroups());
	}
}
