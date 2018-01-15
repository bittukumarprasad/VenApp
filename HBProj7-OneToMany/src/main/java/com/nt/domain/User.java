package com.nt.domain;

import java.util.Set;

public class User {
	// =========Property============
	private int userid;
	private String FirstName;
	private String LastName;
	private String addrs;
	private Set<PhoneNumbers> phones;

	// ===========getters & Setter ====================

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public Set<PhoneNumbers> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumbers> phones) {
		this.phones = phones;
	}

	// ====================toString=================
	@Override
	public String toString() {
		return "User [userid=" + userid + ", FirstName=" + FirstName + ", LastName=" + LastName + ", addrs=" + addrs
				+ ", phones=" + phones + "]";
	}

}
