package ashokRestAssured_tests;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_001getwithparsms {
	
	String BaseUrl = "https://reqres.in/";
	String path = "api/users/3";
	
	@Test
	public void pathrams() {
	RestAssured.baseURI = BaseUrl;
	RestAssured.basePath = path;
	
	Response getresponse = RestAssured.get();
	System.out.println(getresponse.getStatusCode());
	System.out.println(getresponse.asPrettyString());
	
	
	}

}
