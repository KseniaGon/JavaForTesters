package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo; 
import org.testng.annotations.Test;

import com.example.framework.Group;
import com.example.utils.SortedListOf;

public class GroupDeletionTests extends GroupTestsBase {

	public GroupDeletionTests() throws IOException {
		super();
	}

	@Test
	public void DeleteGroup() {
		SortedListOf<Group> oldList = getGroups();

		int index = getRandomValue(oldList.size()-1);
		applicationManager.getGroupHelper().delete(index);

		assertThat(getGroups(), equalTo(oldList.withDeleted(index)));
	}
}
