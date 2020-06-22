package com.person.personapp.model;

import java.util.List;
public class AddressRequestBody {

	private String pid;
	private List<Address> addresses;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
