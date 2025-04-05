package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer{

	private static int MAX_NUMBER_OF_ATTEMPTS=Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	private int CURRENT_ATTEMPT=1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(CURRENT_ATTEMPT<=MAX_NUMBER_OF_ATTEMPTS) {
			CURRENT_ATTEMPT++;
			return true; // this tells to testng Yes, run this this again
		}
		return false;// this tells to testng No, Don't run this this again
		
	}

}
