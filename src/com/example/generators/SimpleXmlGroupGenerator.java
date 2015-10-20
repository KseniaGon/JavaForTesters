package com.example.generators;

import com.example.framework.Group;
import com.thoughtworks.xstream.*;

public class SimpleXmlGroupGenerator extends SimplXmlGeneratorBase {

	public static void main(String[] args) throws Exception {
		SimpleXmlGroupGenerator instance = new SimpleXmlGroupGenerator();
		instance.execute(args);
	}	

	@Override
	protected java.lang.Object getData(int count) {
		return new RandomGroupsGenerator().getRandomData(count);
	}

	@Override
	protected String getProgramName() {
		return SimpleXmlGroupGenerator.class.getName();
	}
	
	@Override
	protected void setupAlias(XStream xmlStream) {
		xmlStream.alias("group", Group.class);
	}	
}
