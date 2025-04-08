package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredLoginTest extends TestBase{
	
	private static final String INVALID_EMAIL_ADDRESS="yogesh@gmail.com";
	private static final String INVALID_PASSWORD="Test1234!";
	
	@Test(description = "Verifies the valid user is unable to login into the application with invalid credentials", 
		  groups = { "e2e","smoke","sanity" })
		public void loginExcelTest() {
			assertEquals(homePage.goToLogInPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).getAuthenticationFailedMessage(),"Authentication failed.");
		}
}
