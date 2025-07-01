package ashok_restassured_practice;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Practice_RequestChaining_001 {

	
	String posturl = "https://thetestingworldapi.com/api/studentsDetails";
	String geturl = "https://thetestingworldapi.com/api/studentsDetails/";
	String PutUrl = "https://thetestingworldapi.com/api/studentsDetails/10495581";
	String DeleteUrl = "https://thetestingworldapi.com/api/studentsDetails/10495581";
	
	@Test
	public void postmethod() {
		
		RequestSpecification PostRequest =RestAssured.given();
		PostRequest.body("{\"id\":10495581,\"first_name\":\"K\",\"middle_name\":\"AA\",\"last_name\":\"Hanvith\",\"date_of_birth\":\"30/11/2023\"}");
		PostRequest.header("content-type", "Application/json");
		
		Response Postresponse =PostRequest.post(posturl);
		System.out.println(Postresponse.getStatusCode());
		System.out.println(Postresponse.asPrettyString());
		
		String studentId =  Postresponse.jsonPath().getString("id");
		
		Response Getresponse =RestAssured.get(geturl+studentId);
		System.out.println(Getresponse.asPrettyString());
		System.out.println(Getresponse.getStatusCode());
		
		RequestSpecification PutRequest =RestAssured.given();
		PutRequest.body("{\"id\":10495581,\"first_name\":\"Kareti\",\"middle_name\":\"AA\",\"last_name\":\"Hanvith\",\"date_of_birth\":\"30/11/2023\"}");
		PutRequest.header("content-type", "Application/json");
		
		Response PutResponse =PutRequest.put(PutUrl);
		System.out.println(PutResponse.getStatusCode());
		System.out.println(PutResponse.asPrettyString());
		
		Response DeleteResponse =RestAssured.delete(DeleteUrl);
		System.out.println(DeleteResponse.getStatusCode());
		System.out.println(DeleteResponse.asPrettyString());
	}
}
