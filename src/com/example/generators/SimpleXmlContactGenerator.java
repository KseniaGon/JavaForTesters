package com.example.generators;

import com.example.framework.Contact;
import com.thoughtworks.xstream.*;

public class SimpleXmlContactGenerator extends SimplXmlGeneratorBase {

	public static void main(String[] args) throws Exception {
		SimpleXmlContactGenerator instance = new SimpleXmlContactGenerator();
		instance.execute(args);
	}	

	@Override
	protected java.lang.Object getData(int count) {
		return new RandomContactsGenerator().getRandomData(count);
	}

	@Override
	protected String getProgramName() {
		return SimpleXmlContactGenerator.class.getName();
	}
	
	@Override
	protected void setupAlias(XStream xmlStream) {
		xmlStream.alias("contact", Contact.class);
	}	
}
