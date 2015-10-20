package com.example.generators;

import java.util.ArrayList;
import java.util.List;

import com.example.framework.Group;

public class RandomGroupsGenerator {

	public List<Group> getRandomData(int count) {
		List<Group> result = new ArrayList<Group>();

		for(int i=0; i<count; i++) {
			result.add(
				new Group()
					.withName(BaseRandomGenerator.generateRandomString("name"))
					.withHeader(BaseRandomGenerator.generateRandomString("header"))
					.withHeader(BaseRandomGenerator.generateRandomString("footer")));
		}

		return result;		
	}

}
