package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo; 
import org.testng.annotations.Test;

import com.example.framework.Group;
import com.example.utils.SortedListOf;

public class GroupCreationTest extends GroupTestsBase {

	@Test(dataProvider = "randomDataProvider")
	public void createGroup(Group group) throws Exception {
		SortedListOf<Group> oldList = getGroups();

		applicationManager.getGroupHelper().create(group);

		assertThat(getGroups(), equalTo(oldList.withAdded(group))); 
	}

	@Test
	public void createGroupWithMultiLineFooter() throws Exception {
		SortedListOf<Group> oldList = getGroups();

		Group group = getGroupTestData()
				.withFooter("first line\r\nsecond line");
		
		applicationManager.getGroupHelper().create(group);

		assertThat(getGroups(), equalTo(oldList.withAdded(group))); 
	}

	private Group getGroupTestData() {
		return new Group(getWellKnownGroupName(), "test header", "test footer");
	}
}
