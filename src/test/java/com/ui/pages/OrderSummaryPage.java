package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderSummaryPage extends BrowserUtility{

	private static final By I_CONFIRM_MY_ORDER_BUTTON=By.xpath("//span[text()='I confirm my order']//parent::button");
	private static final By ORDER_SUCCESS_ALERT_LOCATOR=By.xpath("//p[text()='Your order on My Shop is complete.']");
	public OrderSummaryPage(WebDriver driver) {
		super(driver);
	}
	
	public String selectIConfirmMyOrder() {
		clickOn(I_CONFIRM_MY_ORDER_BUTTON);
		return getVisibleText(ORDER_SUCCESS_ALERT_LOCATOR);
	}

}
