package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestChainning {
	
	String BaseUrl = "https://thetestingworldapi.com/";
	
	String first_name = "Testing";
	String middle_name = "A";
	String last_name = "World";
	String dob = "12/12/2003";
	
	@Test
	public void Requestchainning() {
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.header("content-type", "Application/json");
		PostRequest.body("{\"id\":1,\"first_name\":\"Testing\",\"middle_name\":\"AA\",\"last_name\":\"Hello\",\"date_of_birth\":\"11-11-2000\"}");
		
		Response PostResponse =  PostRequest.post(BaseUrl+"api/studentsDetails");
		System.out.println("Post Request Response");
		System.out.println("**************************");
		System.out.println(PostResponse.getStatusCode());
		System.out.println(PostResponse.asPrettyString());
		
		String studentId = PostResponse.jsonPath().getString("id");
		
	 Response getresponse = RestAssured.get(BaseUrl+"api/technicalskills/"+studentId);
	 System.out.println(getresponse.getStatusCode());
	 System.out.println(getresponse.asPrettyString());
	 
		
		
	}

}
