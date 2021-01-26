package com.testnepal.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public final class JsonReaderUtil {

	private JsonReaderUtil() {}
	
	public static JsonPath rawToJson(Response response) {
		return  new JsonPath(response.body().asString());
	}
}
