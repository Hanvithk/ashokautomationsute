package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestforGet {
	
String BaseUrl = "https://reqres.in";
String path = "/api/users/2";

@Test
public void getmethod() {
	RestAssured.baseURI = BaseUrl;
	RestAssured.basePath= path;
	
	Response getresponse = RestAssured.get();
	System.out.println(getresponse.asPrettyString());
	System.out.println(getresponse.getStatusCode());
}

}
