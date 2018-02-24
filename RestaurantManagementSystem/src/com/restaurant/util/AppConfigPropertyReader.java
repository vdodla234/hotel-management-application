package com.restaurant.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfigPropertyReader {
	private static final String PROPERTY_FILE = "appconfig.properties";
	
	public static String getProperty(String key) {
		String value = null;
		InputStream input;
		try {
			input = AppConfigPropertyReader.class.getResourceAsStream(PROPERTY_FILE);
			Properties p = new Properties();
			p.load(input);
			value = p.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
