package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Group;

public class GroupDeletionTests extends GroupTestsBase {

	@Test
	public void DeleteGroup() {
		List<Group> oldList = this.getGroups();

		int index = this.getRandomValue(oldList.size()-1);
		this.applicationManager.getNavigationHelper().navigateTo("groups");
		this.applicationManager.getGroupHelper().delete(index);

		oldList.remove(index);

		assertEquals(oldList, this.getGroups());
	}
}
