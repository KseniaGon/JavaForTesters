package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.example.framework.Group;

public class GroupDeletionTests extends TestBase {

	@Test
	public void DeleteGroup() {
		List<Group> oldList = this.applicationManager.getGroups();

		int index = 0;
		this.applicationManager.deleteGroup(index);

		oldList.remove(index);

		assertEquals(oldList, this.applicationManager.getGroups());
	}
}
