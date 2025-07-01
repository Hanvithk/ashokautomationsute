package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Getcallwithpathquryparams {
	
	String BaseUrl= "https://reqres.in/";
	String Path= "api/users/";
	
	@Test
	public void Quiryparams() {
		RequestSpecification GetRequest = RestAssured.given();
		GetRequest.baseUri(BaseUrl);
		GetRequest.basePath(Path);
		GetRequest.pathParam("ID", 2);
		
		 Response GetResponse = GetRequest.get("{ID}");
		 System.out.println(GetResponse.getStatusCode());
		 System.out.println(GetResponse.asPrettyString());
	}

}
