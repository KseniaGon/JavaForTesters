package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo; 
import org.testng.annotations.Test;

import com.example.framework.Group;
import com.example.utils.SortedListOf;

public class GroupCreationTest extends GroupTestsBase {

	public GroupCreationTest() throws IOException {
		super();
	}

	@Test(dataProvider = "randomDataProvider")
	public void createRandomGroup(Group group) throws Exception {
		createGroupInternal(group); 
	}

	@Test(dataProvider = "fileDataProvider")
	public void createGroup(Group group) throws Exception {
		createGroupInternal(group); 
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
	
	protected void createGroupInternal(Group group) {
		SortedListOf<Group> oldList = getGroups();

		applicationManager.getGroupHelper().create(group);

		assertThat(getGroups(), equalTo(oldList.withAdded(group)));
	}
	
}
