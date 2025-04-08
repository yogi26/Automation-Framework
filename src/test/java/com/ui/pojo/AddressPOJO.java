package com.ui.pojo;

public class AddressPOJO {
	private String company;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postCode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String otherInformation;
	private String futureRefAddress;
	
	
	public AddressPOJO(String company, String address1, String address2, String city, String state, String postCode,
			String homePhoneNumber, String mobileNumber, String otherInformation, String futureRefAddress) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.otherInformation = otherInformation;
		this.futureRefAddress = futureRefAddress;
	}
	public String getCompany() {
		return company;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public String getFutureRefAddress() {
		return futureRefAddress;
	}
	@Override
	public String toString() {
		return "Address [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", postCode=" + postCode + ", homePhoneNumber=" + homePhoneNumber
				+ ", mobileNumber=" + mobileNumber + ", otherInformation=" + otherInformation + ", futureRefAddress="
				+ futureRefAddress + "]";
	}
	
}
