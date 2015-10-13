package com.example.framework;

public class Contact implements Comparable<Contact> {
	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Contact other = (Contact) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String email;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String groupName;

	public Contact(String firstName, String lastName, String address, String homePhone, String mobilePhone,
			String email, String birthDay, String birthMonth, String birthYear, String groupName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.groupName = groupName;
	}

	public Contact() {
	}

	@Override
	public int compareTo(Contact other) {
		int result = firstName.compareToIgnoreCase(other.firstName);

		if( result==0 ) {
			return lastName.compareToIgnoreCase(other.lastName);
		}

		return result;
	}
}