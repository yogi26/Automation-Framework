package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class AddNewAddressTest extends TestBase{
	private MyAccountPage myAccountPage;
	private AddressPOJO address;
	
	@BeforeMethod
	public void setup() {
		myAccountPage = homePage.goToLogInPage().doLoginWith("giciyeg932@oronny.com", "Yogi@222");
		address=FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description = "This test will Add new address functionality",
		  groups = {"smoke", "e2e"})
	public void addNewAddressTest() {
		String newAddress = myAccountPage.goToAddAddressPage().saveAddress(address);
		assertEquals(newAddress, address.getFutureRefAddress().toUpperCase());
	}
}
