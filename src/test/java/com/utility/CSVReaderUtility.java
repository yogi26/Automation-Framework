package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		File file = new File(System.getProperty("user.dir") + "//testData//"+fileName+".csv");
		FileReader fileReader;
		CSVReader csvReader;
		String[] line;
		List<User> userList;
		try {
			fileReader = new FileReader(file);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();
			userList = new ArrayList<User>();
			while ((line = csvReader.readNext()) != null) {
				userList.add(new User(line[0], line[1]));
			}
			return userList.iterator();
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
