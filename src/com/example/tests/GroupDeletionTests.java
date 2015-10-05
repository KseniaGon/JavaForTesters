package com.example.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

	@Test
	public void DeleteGroup() {
		this.applicationManager.deleteGroup(1);
	}
	
}
