package com.example.tests.helpers;

public class Contact {
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
}