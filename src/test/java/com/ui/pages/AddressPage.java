package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS_LINE2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By ZIP_CODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By MOBILE_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.id("phone");
	private static final By ADDITIONAL_INFO_TEXTAREA_LOCATOR = By.id("other");
	private static final By FUTURE_REF_ADDRESS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By DELETE_ADDRESS_LOCATOR = By.xpath("//a[@title='Delete']");
	private static final By ADDRESS_HEADING_LOCATOR = By.xpath("//h3[contains(text(),'Office Address')]");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//button[@name='processAddress']");

	public AddressPage(WebDriver driver) {
		super(driver);
	}

	public String saveAddress(AddressPOJO address) {
		enterText(COMPANY_TEXTBOX_LOCATOR, address.getCompany());
		enterText(ADDRESS_TEXTBOX_LOCATOR, address.getAddress1());
		enterText(ADDRESS_LINE2_TEXTBOX_LOCATOR, address.getAddress2());
		enterText(CITY_TEXTBOX_LOCATOR, address.getCity());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, address.getState());
		enterText(ZIP_CODE_TEXTBOX_LOCATOR, address.getPostCode());
		enterText(MOBILE_TEXTBOX_LOCATOR, address.getMobileNumber());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR, address.getHomePhoneNumber());
		enterText(ADDITIONAL_INFO_TEXTAREA_LOCATOR, address.getOtherInformation());
		clearText(FUTURE_REF_ADDRESS_TEXTBOX_LOCATOR);
		enterText(FUTURE_REF_ADDRESS_TEXTBOX_LOCATOR, address.getFutureRefAddress());
		clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
		return getVisibleText(ADDRESS_HEADING_LOCATOR);
	}

	public ShippingPage proceedToAddress() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShippingPage(getDriver());
	}

}
