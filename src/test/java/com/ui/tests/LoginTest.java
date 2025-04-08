package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase{

	@Test(description = "Verifies the valid user is able to login into the application", 
		  groups = { "e2e", "smoke" }, 
		  dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
		  dataProvider = "LoginTestDataProvider",
		  enabled = false)
	public void loginTest(User user) {
		assertEquals(homePage.goToLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Yogesh Giri");
	}

	@Test(description = "Verifies the valid user is able to login into the application", 
		  groups = { "e2e", "smoke" }, 
		  dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
		  dataProvider = "LoginTestCSVDataProvider",
		  enabled = false)
	public void loginCSVTest(User user) {
		assertEquals(homePage.goToLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Yogesh Giri");
	}
	
	@Test(description = "Verifies the valid user is able to login into the application", 
		  groups = { "e2e","smoke" }, 
		  dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
		  dataProvider = "LoginTestExcelDataProvider", 
		  retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {
		assertEquals(homePage.goToLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Yogesh Giri");
	}
}
