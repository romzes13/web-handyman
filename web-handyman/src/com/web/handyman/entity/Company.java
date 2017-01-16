package com.web.handyman.entity;

public class Company {
	
	private int    companyId;
	
	private String companyName;
	
	private String address;
	
	private String phoneNumber;

	public Company(){
		
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Company(int companyId, String companyName, String address, String phoneNumber) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
