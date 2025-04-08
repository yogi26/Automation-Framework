package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase {
	
	protected HomePage homePage;
	private boolean isLambdaTest;
	
	
	@Parameters({"browser","isHeadless","isLambdaTest"})
	@BeforeMethod(description = "Load the Homepage of the site")
	public void setUp(@Optional("chrome") String browser, 
					  @Optional("false") boolean isHeadless, 
					  @Optional("false") boolean isLambdaTest, 
					  ITestResult result) {
		this.isLambdaTest=isLambdaTest;
		WebDriver remoteDriver;
		if(isLambdaTest) {
			remoteDriver = LambdaTestUtility.initializeLamdaTestSession(browser, result.getMethod().getMethodName());
			homePage=new HomePage(remoteDriver);//this will run test on remote (lambda) machine
		}
		else {
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);//this will run test on local machine	
		}
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
		else {
			homePage.quit();
		}
	}
}
