package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility{

	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.xpath("//button[@name='processCarrier']");
	private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR=By.id("uniform-cgv");
	public ShippingPage(WebDriver driver) {
		super(driver);
	}
	
	public PaymentPage selectTermsOfServiceAndProceedToCheckout() {
		clickOn(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}
	


}
