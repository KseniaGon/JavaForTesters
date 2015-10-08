package com.example.tests.helpers;

public class Group implements Comparable<Group> {
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

	public String name;
	public String header;
	public String footer;

	public Group(String name, String header, String footer) {
		this.name = name;
		this.header = header;
		this.footer = footer;
	}

	public Group() {
	}

	@Override
	public int compareTo(Group other) {
		return this.name.compareToIgnoreCase(other.name);
	}
}