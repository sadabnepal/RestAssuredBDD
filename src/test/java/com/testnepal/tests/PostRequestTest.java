package com.testnepal.tests;

import java.io.File;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.testnepal.base.CRUDOperation;
import com.testnepal.constants.FilePathConstants;
import com.testnepal.utils.JsonReaderUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public final class PostRequestTest {

	private PostRequestTest() {}

	@Test
	public void createUser() {
		String expected_username = "morpheus";
		String expected_jobTitle = "leader";

		File userbody = new File(FilePathConstants.getCreateUserJsonFilePath());
		Response response = CRUDOperation.sendPOSTRequest("CREATE_USER", userbody);
		response.then().assertThat().statusCode(201);

		JsonPath actualResponse = JsonReaderUtil.rawToJson(response);
		String createdName = actualResponse.getString("name");
		String createdJobTitle = actualResponse.getString("job");
		String id = actualResponse.get("id");

		Assert.assertEquals(expected_username, createdName);
		Assert.assertEquals(expected_jobTitle, createdJobTitle);
		System.out.println("ID Created: "+id);
	}
}
