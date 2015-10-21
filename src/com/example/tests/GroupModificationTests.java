package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo; 

import org.testng.annotations.Test;

import com.example.framework.Group;
import com.example.utils.SortedListOf;

public class GroupModificationTests extends GroupTestsBase {

	public GroupModificationTests() throws IOException {
		super();
	}

	@Test(dataProvider = "randomDataProvider")
	public void UpdateGroup(Group group) {
		SortedListOf<Group> oldList = getGroups();

		int index = getRandomValue(oldList.size()-1);
		applicationManager.getGroupHelper().update(index, group);

		assertThat(
			getGroups(), 
			equalTo(
				oldList
					.withDeleted(index)
					.withAdded(group)));
	}
}