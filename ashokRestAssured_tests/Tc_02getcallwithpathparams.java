package ashokRestAssured_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc_02getcallwithpathparams {

	String baseurl = "https://reqres.in/";
	String path = "api/users/";
	
	@Test
	public void pathparams() {
		RequestSpecification GetRequest = RestAssured.given();
		GetRequest.baseUri(baseurl);
		GetRequest.basePath(path);
		GetRequest.pathParam("ID", 3);
		
		Response getresponse = GetRequest.get("{ID}");
		System.out.println(getresponse.getStatusCode());
		System.out.println(getresponse.asPrettyString());
		System.out.println(getresponse.headers());
		System.err.println(getresponse.getHeader("Date"));
		
		Assert.assertEquals(getresponse.jsonPath().getString("data.first_name"), "Emma");
		Assert.assertTrue(getresponse.asPrettyString().contains("https://reqres.in/img/faces/3-image.jpg"));
		
	}
}
