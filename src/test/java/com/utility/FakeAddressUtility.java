package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	public static void main(String[] args) {
		getFakeAddress();
	}
	public static AddressPOJO getFakeAddress() {
		Faker faker=new Faker(Locale.US);
		
		return new AddressPOJO(faker.company().name(), 
							   faker.address().buildingNumber(), 
							   faker.address().streetAddress(), 
							   faker.address().city(), 
							   faker.address().state(), 
							   "12345", 
							   faker.phoneNumber().cellPhone(), 
							   faker.phoneNumber().cellPhone(), 
							   "Other", 
							   "Office Address");
	}
}
