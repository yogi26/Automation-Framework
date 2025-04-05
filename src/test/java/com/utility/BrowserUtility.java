package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	Logger logger= LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driverManager=new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {
		driverManager.set(driver);
	}
	public BrowserUtility(Browser browserName) {
		logger.info(browserName+" Brawser launched");
		if(browserName==Browser.CHROME) {
			driverManager.set(new ChromeDriver());
		}
		else if(browserName==Browser.EDGE) {
			driverManager.set(new EdgeDriver());
		}
		else if(browserName==Browser.FIREFOX) {
			driverManager.set(new FirefoxDriver());
		}
	}
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info(browserName+" Brawser launched");
		if(isHeadless) {
			if(browserName==Browser.CHROME) {
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driverManager.set(new ChromeDriver(options));
			}
			else if(browserName==Browser.EDGE) {
				EdgeOptions options=new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
				driverManager.set(new EdgeDriver(options));
			}
			else if(browserName==Browser.FIREFOX) {
				FirefoxOptions options=new FirefoxOptions();
				options.addArguments("--headless");
				driverManager.set(new FirefoxDriver(options));
			}
		}
		else {
			if(browserName==Browser.CHROME) {
				driverManager.set(new ChromeDriver());
			}
			else if(browserName==Browser.EDGE) {
				driverManager.set(new EdgeDriver());
			}
			else if(browserName==Browser.FIREFOX) {
				driverManager.set(new FirefoxDriver());
			}
		}
		
	}
	
	public WebDriver getDriver() {
		return driverManager.get();
	}
	public void goToWebSite(String url) {
		logger.info("Navigating to : "+url);
		driverManager.get().get(url);
	}
	public void maximizeWindow() {
		logger.info("Broswer maximized");
		driverManager.get().manage().window().maximize();
	}
	public void clickOn(By locator) {
		logger.info("Clicking on : " + locator);
		WebElement element = driverManager.get().findElement(locator);
		element.click();
	}
	public void enterText(By locator, String text) {
		logger.info("Entering text in : "+locator);
		WebElement element = driverManager.get().findElement(locator);
		element.sendKeys(text);
	}
	public String getVisibleText(By locator) {
		logger.info("Fetching visible text from : "+locator);
		WebElement element = driverManager.get().findElement(locator);
		return element.getText();
	}
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot)driverManager.get();
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String path=System.getProperty("user.dir")+"//screenshots//"+name+"-"+timestamp+".png";
		File screenshotFile=new File(path);
		File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
