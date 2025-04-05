package com.ui.pages;

import static com.constants.Env.QA;
import static com.utility.PropertiesUtil.readProperty;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility{
	Logger logger= LoggerUtility.getLogger(this.getClass());
	
	private static final By SIGN_IN_LINK_LOCATOR= By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebSite(readProperty(QA, "URL"));
	}
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		goToWebSite(readProperty(QA, "URL"));
	}
	
	public LoginPage goToLogInPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}
	public void quit() {
		getDriver().quit();
	}
}
