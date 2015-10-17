package com.example.framework;

public class Card implements Comparable<Card>  {
	private String firstAndLastNames;
	private String homePhone;
	
	@Override
	public int compareTo(Card other) {
		int compare = this.firstAndLastNames.compareTo(other.firstAndLastNames);
		if( compare!=0 ) {
			return this.homePhone.compareTo(other.homePhone);
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Card [firstAndLastNames=" + firstAndLastNames + ", homePhone=" + homePhone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstAndLastNames == null) ? 0 : firstAndLastNames.hashCode());
		result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
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
		Card other = (Card) obj;
		if (firstAndLastNames == null) {
			if (other.firstAndLastNames != null)
				return false;
		} else if (!firstAndLastNames.equals(other.firstAndLastNames))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		return true;
	}

	public String getFirstAndLastNames() {
		return firstAndLastNames;
	}

	public String getHomePhone() {
		return homePhone;
	}
	
	public Card withFirstAndLastName(String firstAndLastName) {
		this.firstAndLastNames = firstAndLastName;
		return this;
	}

	public Card withPhone(String phone) {
		this.homePhone = phone;
		return this;
	}
}
