package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	
	public static String readProperty(Env env, String propertyName) {
		File file=new File(System.getProperty("user.dir")+"//config//"+env+".properties");
		FileReader fileReader;
		Properties prop = null;
		try {
			fileReader = new FileReader(file);
			prop=new Properties();
			prop.load(fileReader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(propertyName.toUpperCase());	
	}
}
