package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{

	public static final By PAY_BY_CHEQUE_OPTION_LOCATOR=By.xpath("//a[@title='Pay by check.']");
	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	public OrderSummaryPage choosePayByChequeOption() {
		clickOn(PAY_BY_CHEQUE_OPTION_LOCATOR);
		return new OrderSummaryPage(getDriver());
	}
}
