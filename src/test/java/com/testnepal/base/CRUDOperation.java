package com.testnepal.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.File;

import com.testnepal.enums.APIServices;
import com.testnepal.utils.PropertyReaderUtil;

import io.restassured.response.Response;

public class CRUDOperation {

	static {
		RestAssured.baseURI =  PropertyReaderUtil.getPropertyValue("url");
	}

	public static Response sendGETRequest(String apiServiceName) {
		String serviceName = APIServices.getAPIResourceName(apiServiceName);	
		Response response =  RestAssured.given()
				.get(serviceName);
		return response;
	}

	public static Response sendPOSTRequest(String apiServiceName, String requestBody) {
		String serviceName = APIServices.getAPIResourceName(apiServiceName);
		Response response = RestAssured.given()
				.when()
				.body(requestBody)
				.contentType(ContentType.JSON)
				.post(serviceName);
		return response;
	}

	public static Response sendPOSTRequest(String apiServiceName, File requestBody) {
		String serviceName = APIServices.getAPIResourceName(apiServiceName);
		Response response = RestAssured.given()
				.when()
				.body(requestBody)
				.contentType(ContentType.JSON)
				.post(serviceName);
		return response;
	}
}
