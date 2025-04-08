package com.ui.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)
public class ProductSearchTest extends TestBase{

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed summer dress";
	
	@BeforeMethod
	public void setup() {
		myAccountPage = homePage.goToLogInPage().doLoginWith("giciyeg932@oronny.com", "Yogi@222");
	}
	
	@Test(description = "This test will search a product and will display the result",
		  groups = {"smoke", "e2e"})
	public void productSearchTest() {
		boolean actualResult = myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		assertTrue(actualResult, "true");
	}
}
