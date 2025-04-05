package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	@DataProvider(name="LoginTestExcelDataProvider")
	public static Iterator<User> readExcelFile(String fileName) {
		File file = new File(System.getProperty("user.dir") + "//testData//"+fileName+".xlsx");
		XSSFSheet xssfsheet = null;
		List<User> userList;
		Cell emailAddressCell;
		Cell passwordCell;

		try (XSSFWorkbook xssfworkbook = new XSSFWorkbook(file)) {
			xssfsheet = xssfworkbook.getSheet("LoginTestData");
			Iterator<Row> rowIterator = xssfsheet.iterator();
			rowIterator.next();
			userList = new ArrayList<User>();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				userList.add(new User(emailAddressCell.toString(), passwordCell.toString()));
			}
			return userList.iterator();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
