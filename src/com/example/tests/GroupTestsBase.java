package com.example.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.example.framework.Group;
import com.example.generators.GroupFileReader;
import com.example.generators.RandomGroupsGenerator;
import com.example.utils.SortedListOf;

public class GroupTestsBase extends TestBase {

	public GroupTestsBase() throws IOException {
		super();
	}

	protected SortedListOf<Group> getGroups() {
		return applicationManager.getGroupHelper().getGroups();
	}

	@DataProvider
	public Iterator<Object[]> randomDataProvider() {
		List<Object[]> result = new ArrayList<Object[]>();
		
		for(Group group :  new RandomGroupsGenerator().getRandomData(2) ) {
			result.add(new Object[] { group } ); 
		}
		
		return result.iterator();
	}
	
	@DataProvider
	protected Iterator<Object[]> fileDataProvider() {
		List<Object[]> result = new ArrayList<Object[]>();

		for(Group contact: new GroupFileReader().read() ) {
			result.add(new Object[] { contact  });
		}
		
		return result.iterator();		
	}	
}
