package com.testnepal.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.testnepal.constants.FilePathConstants;

public final class PropertyReaderUtil {

	private PropertyReaderUtil() {}
	static Properties prop;
	
	static {
		prop = new Properties();
		try (FileInputStream fis = new FileInputStream(FilePathConstants.getConfigFilePath())){
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}
}
