package ashokRestAssured_tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getmethodwithpathparams {

	String baseurl = "https://reqres.in/api/";
	String path = "users?";
	
	// https://reqres.in/api/users?page=2
	
	@Test
	public void pathparams() {
		RequestSpecification GetRequest =RestAssured.given();
		GetRequest.baseUri(baseurl);
		GetRequest.basePath(path);
		//GetRequest.pathParam("ID", 3);
		GetRequest.queryParam("page", 2);
		GetRequest.log().all();
		
		Response GetResponse =GetRequest.get("{page}");
		System.out.println(GetResponse.getStatusCode());
		System.out.println(GetResponse.asPrettyString());
		
		Assert.assertEquals(GetResponse.jsonPath().getString("data.first_name[1]"), "Lindsay");
		
	}
}
