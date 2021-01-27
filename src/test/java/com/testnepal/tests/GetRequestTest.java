package com.testnepal.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testnepal.base.CRUDOperation;
import com.testnepal.utils.JsonReaderUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public final class GetRequestTest {

	private GetRequestTest() {}

	@Test
	public static void getUsers() {	
		System.out.println("Sending Request to fetch multiple user data...");
		Response response = CRUDOperation.sendGETRequest("GET_LIST_OF_USERS");
		response.then().assertThat().statusCode(200);
		
		JsonPath actualJsonResponse = JsonReaderUtil.rawToJson(response);
		int allData = actualJsonResponse.getInt("data.size()");
		for(int i=0; i<allData; i++) {
			String email = actualJsonResponse.getString("data["+i+"].email").toLowerCase();
			System.out.println("Fetching Email "+i+": "+email);
			String fname = actualJsonResponse.getString("data["+i+"].first_name").toLowerCase();
			String lname = actualJsonResponse.getString("data["+i+"].last_name").toLowerCase();
			Assert.assertEquals(email, fname+"."+lname+"@reqres.in", "Validating Name with email ID");
		}
		System.out.println("All user data received...");
	}
	
	@Test
	public static void getSingleUser() {
		System.out.println("Sending Request to fetch single user data...");
		Response response  = CRUDOperation.sendGETRequest("GET_SINGLE_USER");
		response.then().assertThat().statusCode(200);
		
		JsonPath singleUserBody =  JsonReaderUtil.rawToJson(response);
		String email = singleUserBody.getString("data.email").toLowerCase();
		String fname = singleUserBody.getString("data.first_name").toLowerCase();
		String lname = singleUserBody.getString("data.last_name").toLowerCase();
		Assert.assertEquals(email, fname+"."+lname+"@reqres.in", "Validating Name with email ID");
		System.out.println("Single user data fetched...");
		
	}
}
