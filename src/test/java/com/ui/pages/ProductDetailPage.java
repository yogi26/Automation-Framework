package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility{

	private static final By SIZE_DROPDOWN_LOCATOR=By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR=By.xpath("//button[@name='Submit']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.xpath("//a[@title='Proceed to checkout']");
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	public ProductDetailPage changeSize(Size size) {
		selectFromDropdown(SIZE_DROPDOWN_LOCATOR, size.toString());
		return new ProductDetailPage(getDriver());
	}
	public ProductDetailPage addToProductToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailPage(getDriver());
	}
	public ShoppingCartPage proceedToProductDetails() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartPage(getDriver());
	}
}
