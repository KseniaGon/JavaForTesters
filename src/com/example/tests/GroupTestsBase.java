package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.example.framework.Group;
import com.example.utils.SortedListOf;

public class GroupTestsBase extends TestBase {

	protected SortedListOf<Group> getGroups() {
		applicationManager.navigateTo().groups();
		return applicationManager.getGroupHelper().getGroups();
	}

	@DataProvider
	public Iterator<Object[]> randomDataProvider() {
		List<Object[]> result = new ArrayList<Object[]>();

		for(int i=0; i<5; i++) {
			Group group = new Group();
			group.name = generateRandomString("name");
			group.header = generateRandomString("header");
			group.header = generateRandomString("footer");

			result.add(new Object[] { group  });
		}

		return result.iterator();
	}

}
