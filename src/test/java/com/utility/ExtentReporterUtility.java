package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {

	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> threadLocalExtentTest=new ThreadLocal<ExtentTest>();
	
	public static void setUpSparkReporter(String reportName) {
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//"+reportName);
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	public static void createExtentTest(String testName) {
		ExtentTest test=extentReports.createTest(testName);
		threadLocalExtentTest.set(test);
	}
	public static ExtentTest getTest() {
		return threadLocalExtentTest.get();
	}
	public static void flushReport() {
		extentReports.flush();
	}
}
