package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static Environment readJSON(Env env)  {
		Gson gson=new Gson();
		File file=new File(System.getProperty("user.dir")+"\\config\\config.json");
		Config config = null;
		try {
			config = gson.fromJson(new FileReader(file), Config.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return config.getEnvironments().get(env);
	}
}
