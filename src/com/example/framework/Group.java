package com.example.framework;

public class Group implements Comparable<Group> {
	public String getName() {
		return name;
	}

	public String getHeader() {
		return header;
	}

	public String getFooter() {
		return footer;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private String name;
	private String header;
	private String footer;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public Group(String name, String header, String footer) {
		this.name = name;
		this.header = header;
		this.footer = footer;
	}

	public Group() {
	}

	@Override
	public int compareTo(Group other) {
		return name.compareToIgnoreCase(other.name);
	}

	public Group withFooter(String footer) {
		this.footer = footer;
		return this;
	}
	
	public Group withHeader(String header) {
		this.header = header;
		return this;
	}
	
	public Group withName(String name) {
		this.name = name;
		return this;
	}

	public Group withId(String id) {
		this.id = id;
		return this;
	}
}