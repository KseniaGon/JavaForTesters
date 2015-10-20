package com.example.generators;

import java.io.File;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public abstract class FileReaderBase<T> {

	public FileReaderBase() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<T> read() {
		return (List<T>) readObject();
	}
	
	protected Object readObject() {
		XStream xmlStream  = new XStream();
		File file = new File(getFileName());
		xmlStream.alias(getAliasName(), getClassDefinition());
		return xmlStream.fromXML(file);
	}

	protected abstract String getAliasName();

	protected abstract Class<T> getClassDefinition();

	protected abstract String getFileName();
}