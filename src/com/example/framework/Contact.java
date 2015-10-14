package com.example.framework;

public class Contact implements Comparable<Contact> {
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getGroupName() {
		return groupName;
	}

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

	private String firstName;
	private String lastName;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String email;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String groupName;

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
	
	public Contact withGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}

	public Contact withfirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Contact withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

}