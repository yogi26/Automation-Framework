package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	WebDriverWait wait;

	private static ThreadLocal<WebDriver> driverManager = new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {
		driverManager.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(Browser browserName) {
		logger.info(browserName + " Brawser launched");
		if (browserName == Browser.CHROME) {
			driverManager.set(new ChromeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.EDGE) {
			driverManager.set(new EdgeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.FIREFOX) {
			driverManager.set(new FirefoxDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info(browserName + " Brawser launched");
		if (isHeadless) {
			if (browserName == Browser.CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driverManager.set(new ChromeDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
			} else if (browserName == Browser.EDGE) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
				driverManager.set(new EdgeDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
			} else if (browserName == Browser.FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driverManager.set(new FirefoxDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
			}
		} else {
			if (browserName == Browser.CHROME) {
				driverManager.set(new ChromeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
			} else if (browserName == Browser.EDGE) {
				driverManager.set(new EdgeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
			} else if (browserName == Browser.FIREFOX) {
				driverManager.set(new FirefoxDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
			}
		}

	}

	public WebDriver getDriver() {
		return driverManager.get();
	}

	public void goToWebSite(String url) {
		logger.info("Navigating to : " + url);
		driverManager.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Broswer maximized");
		driverManager.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Clicking on : " + locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		//WebElement element = driverManager.get().findElement(locator);
		element.click();
	}

	public void clickOn(WebElement element) {
		
		logger.info("Clicking on : " + element.getText());
		element.click();
	}

	public void enterText(By locator, String text) {
		logger.info("Entering text in : " + locator);
		//WebElement element = driverManager.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}

	public void clearText(By locator) {
		logger.info("Clearing text from : " + locator);
		//WebElement element = driverManager.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.clear();
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Entering key in : " + locator);
		//WebElement element = driverManager.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Fetching visible text from : " + locator);
		WebElement element = driverManager.get().findElement(locator);
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
		return element.getText();
	}

	public void selectFromDropdown(By DropdownLocator, String optionToSelect) {
		logger.info("Finding element with the locator : " + DropdownLocator);
		WebElement element = getDriver().findElement(DropdownLocator);
		Select select = new Select(element);
		logger.info("Selecting visible text : " + optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Fetching all visible text from : " + locator);
		List<WebElement> elements = driverManager.get().findElements(locator);
		List<String> listOfVisibleTexts = new ArrayList<String>();
		for (WebElement ele : elements) {
			listOfVisibleTexts.add(getVisibleText(ele));
		}
		return listOfVisibleTexts;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Fetching all elements : " + locator);
		return driverManager.get().findElements(locator);
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driverManager.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timestamp + ".png";
		File screenshotFile = new File(path);
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public String takeScreenshotBase64(String name) {
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driverManager.get();
			String base64Image = screenshot.getScreenshotAs(OutputType.BASE64);
			return base64Image;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
