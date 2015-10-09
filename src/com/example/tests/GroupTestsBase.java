package com.example.tests;

import java.util.List;

import com.example.framework.Group;

public class GroupTestsBase extends TestBase {

	protected List<Group> getGroups() {
		this.applicationManager.getNavigationHelper().navigateTo("groups");
		return this.applicationManager.getGroupHelper().getGroups();
	}

}
