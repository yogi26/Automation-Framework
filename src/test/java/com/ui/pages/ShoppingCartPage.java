package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility{

	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.xpath("//p//a[@title='Proceed to checkout']");
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	public AddressPage proceedToShoppingCart() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new AddressPage(getDriver());
	}

}
