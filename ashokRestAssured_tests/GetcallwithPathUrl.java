package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetcallwithPathUrl {

	String BaseUrl = "https://thetestingworldapi.com/";
	String path = "api/studentsDetails";
	
	@Test
	public void passingthepathparams() {
		RestAssured.baseURI = BaseUrl;
		RestAssured.basePath = path;
		Response GetResponse = RestAssured.get();
		System.out.println(GetResponse.getStatusCode());
		System.out.println(GetResponse.asPrettyString());
	
	}
}