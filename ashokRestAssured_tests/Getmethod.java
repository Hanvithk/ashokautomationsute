package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getmethod {
	
	String BaseUrl = "https://reqres.in/";
	String path = "api/users/";
	
	@Test
	public void getmethod() {
		RequestSpecification getrequest=RestAssured.given();
		getrequest.baseUri(BaseUrl);
		getrequest.patch(path);
		getrequest.pathParam("ID", "2");
		
		Response GetResponse =getrequest.get("{ID}");
		System.out.println(GetResponse.getStatusCode());
		System.out.println(GetResponse.asPrettyString());
	}

}
