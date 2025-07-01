package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testforpathparams {
	String BaseUrl = "https://reqres.in";
	String path = "/api/users/";
	
@Test
public void pathparamstest() {
	RequestSpecification getRequest = RestAssured.given();
	getRequest.baseUri(BaseUrl);
	getRequest.basePath(path);
	getRequest.pathParam("ID", 2);
	
	 Response Getresponse= getRequest.get("{ID}");
	 System.out.println(Getresponse.getStatusCode());
	 System.out.println(Getresponse.asPrettyString());
	 System.out.println(Getresponse.headers());
	
}
}
