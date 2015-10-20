package com.example.generators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

public abstract class SimplXmlGeneratorBase {

	private static int count;
	private static File file;

	public void execute(String[] args) throws IOException {
		if( initialize(args) ) {
			XStream xmlStream  = new XStream();
			FileWriter writer = new FileWriter(file);
			setupAlias(xmlStream);
			xmlStream.toXML(getData(count), writer);
			writer.close();
		}
	}

	protected abstract void setupAlias(XStream xmlStream);

	protected abstract Object getData(int count);

	private boolean initialize(String[] args) {
		if(args==null || args.length==0) {
			System.out.println(String.format("Syntax: %s filename count", getProgramName()));
			return false;
		}
		
		String fileName = args[0];
		file = new File(fileName);
		if( file.exists()  ) {
			System.out.println(String.format("File %s already exists", fileName));
			return false;
		}
		
		if( args.length<2 ) {
			System.out.println(String.format("Please provide count"));
			return false;
		}
		
		count = Integer.parseInt(args[1]);
		return true;
	}

	protected abstract String getProgramName();
}