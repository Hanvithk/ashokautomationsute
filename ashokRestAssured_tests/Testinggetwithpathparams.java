package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testinggetwithpathparams {

	String baseurl = "https://reqres.in";
	String path = "/api/users/";
	
	@Test
	public void getmethod() {
		RequestSpecification getrequest =RestAssured.given();
		getrequest.baseUri(baseurl);
		getrequest.basePath(path);
		getrequest.pathParam("id", 2);
		
		Response getresponse =getrequest.get("{id}");
		System.out.println(getresponse.getStatusCode());
		System.out.println(getresponse.asPrettyString());
	}
}
