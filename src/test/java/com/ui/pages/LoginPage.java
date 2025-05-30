package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class LoginPage extends BrowserUtility{

	Logger logger= LoggerUtility.getLogger(this.getClass());
	
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']");
	private static final By PASSWORD_TEXT_BOX_LOCATOR=By.xpath("//input[@id='passwd']");
	private static final By SIGN_IN_BUTTON_LOCATOR=By.xpath("//button[@id='SubmitLogin']");
	private static final By AUTHENTICATION_FAILED_MSG_LOCATOR=By.xpath("//div[contains(@class,'alert alert-danger')]//li");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String emailAddress, String password) {
		logger.info("Logging in to application");
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		return new MyAccountPage(getDriver());
	}
	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {
		logger.info("Logging in to application with invalid credentials");
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		return new LoginPage(getDriver());
	}
	public String getAuthenticationFailedMessage() {
		logger.info("Auth Login Failed Text fetched :"+getVisibleText(AUTHENTICATION_FAILED_MSG_LOCATOR));
		return getVisibleText(AUTHENTICATION_FAILED_MSG_LOCATOR);
	}
	
}
