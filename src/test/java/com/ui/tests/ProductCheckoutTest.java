package com.ui.tests;

import static com.constants.Size.M;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

@Listeners(com.ui.listeners.TestListener.class)
public class ProductCheckoutTest extends TestBase {

	private SearchResultPage searchResultPage;
	private static final String SEARCH_TERM = "Printed summer dress";

	@BeforeMethod(description = "")
	public void setup() {
		searchResultPage = homePage.goToLogInPage().doLoginWith("giciyeg932@oronny.com", "Yogi@222").searchForProduct(SEARCH_TERM);
	}

	@Test(description = "This test will verify complete checkout process", groups = { "smoke", "e2e" })
	public void productCheckoutTest() {
		String alertSuccess=searchResultPage
							.clickOnTheProductAtIndex(0)
							.changeSize(M)
							.addToProductToCart()
							.proceedToProductDetails()
							.proceedToShoppingCart()
							.proceedToAddress()
							.selectTermsOfServiceAndProceedToCheckout()
							.choosePayByChequeOption()
							.selectIConfirmMyOrder();
		assertEquals(alertSuccess, "Your order on My Shop is complete.");
	}
}
