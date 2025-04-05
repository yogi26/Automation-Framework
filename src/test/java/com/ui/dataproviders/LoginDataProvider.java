package com.ui.dataproviders;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name="LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() {
		Gson gson=new Gson();
		File file=new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
		try {
			FileReader fileReader=new FileReader(file);
			TestData data = gson.fromJson(fileReader, TestData.class);
			
			List<Object[]> dataToReturn=new ArrayList<Object[]>();
			for(User user:data.getData()) {
				dataToReturn.add(new Object[] {user});
			}
			return dataToReturn.iterator();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData");
	}
	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("loginData");
	}
}
