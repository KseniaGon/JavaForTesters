package com.example.generators;

import com.example.framework.Group;

public class GroupFileReader extends FileReaderBase<Group> {
	
	@Override
	protected Class<Group> getClassDefinition() {
		return Group.class;
	}

	@Override
	protected String getFileName() {
		return "groups.xml";
	}

	protected String getAliasName() {
		return "group";
	}
}
