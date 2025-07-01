package ashokRestAssured_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getmethod_testing {

	String BaseUrl = "https://thetestingworldapi.com/api/studentsDetails";
	
	@Test
	public void getmethod() {
		Response GetResponse = RestAssured.get(BaseUrl);
		System.out.println(GetResponse.getStatusCode());
		System.out.println(GetResponse.asPrettyString());
		
		Assert.assertTrue(GetResponse.asString().contains("Asiful"));
	}
	
}
