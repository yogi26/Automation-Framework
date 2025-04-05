package com.utility;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver initializeLamdaTestSession(String browserName, String testName) {
		try 
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability("browserName", browserName);
			capabilities.setCapability("browserVersion", "127");
			Map<String, Object> ltOptions = new HashMap<>();
			ltOptions.put("user", "yogeshgiri263");
			ltOptions.put("accessKey", "LT_ONKAlm8CqdR148mX07VYBP98gXltrJ5Uze6G0eaROBM8pW7");
			ltOptions.put("build", "Selenium 4");
			ltOptions.put("name", testName);
			ltOptions.put("platformName", "Windows 10");
			ltOptions.put("seCdp", true);
			ltOptions.put("selenium_version", "4.23.0");
			capabilities.setCapability("LT:Options", ltOptions);

			capabilitiesLocal.set(capabilities);

			WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
			driverLocal.set(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driverLocal.get();
	}

	public static void quitSession() {
		if (driverLocal.get() != null) {
			driverLocal.get().quit();
		}
	}
}
