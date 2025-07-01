package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Testing_getcallwithparams {

	String baseurl = "https://thetestingworldapi.com/";
	String path = "api/studentsDetails";
	
	@Test
	public void getmethod() {
		RestAssured.baseURI = baseurl;
		RestAssured.basePath = path;
		Response GetResponse= RestAssured.get();
		System.out.println(GetResponse.statusCode());
		System.out.println(GetResponse.asPrettyString());
	}
}
