package ashokRestAssured_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Tc_001 {
	String BaseUrl = "https://reqres.in/";
	String path = "api/users/";
	
	@Test
	public void pathparams() {
		RequestSpecification Request = RestAssured.given();
		Request.baseUri(BaseUrl);
		Request.basePath(path);
		Request.pathParam("ID", "3");
		System.out.println(Request.log().all());
		
		Response Getresponse = Request.get("{ID}");
		System.out.println(Getresponse.statusCode());
		System.out.println(Getresponse.asPrettyString());
		
		
		Assert.assertEquals(Getresponse.jsonPath().getString("data.first_name"), "Emma");
		Assert.assertTrue(Getresponse.asString().contains("Wong"));
	}

}
