package com.testnepal.constants;

public final class FilePathConstants {

	private FilePathConstants() {}
	
	private static final String CONFIG_FILE_PATH = System.getProperty("user.dir")+"/config.properties";
	private static final String RESOURCE_FOLDER_PATH = System.getProperty("user.dir")+"/src/test/resources/";
	private static final String CREATE_USER_JSON_FILE_PATH = "payloads/CreateUser.json";
	
	public static String getResourceFolderPath() {
		return RESOURCE_FOLDER_PATH;
	}
	public static String getCreateUserJsonFilePath() {
		return getResourceFolderPath()+CREATE_USER_JSON_FILE_PATH;
	}
	
	public static String getConfigFilePath() {
		return CONFIG_FILE_PATH;
	}
	
}
