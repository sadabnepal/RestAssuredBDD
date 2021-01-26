package com.testnepal.enums;

public enum APIServices {
	
	GET_LIST_OF_USERS("/api/users?page=2"),
	GET_SINGLE_USER("/api/users/2"),
	CREATE_USER("/api/users");

	private String resources;
	
	APIServices(String resources) {
		this.resources = resources;
	}
	
	public String getServices() {
		return resources;
	}
	
	public static String getAPIResourceName(String enumServiceName) {
		return APIServices.valueOf(enumServiceName).getServices();
	}

}
