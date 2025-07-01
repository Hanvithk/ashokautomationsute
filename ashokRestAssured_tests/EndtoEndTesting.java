package ashokRestAssured_tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndtoEndTesting {
	String baseUrl = "https://thetestingworldapi.com/";
	
	
	@Test
	public void EndtoendTestingwithallApis() {
		File f=new File("C:\\C-Drive\\hanveth\\AutomationTesting\\src\\RequestPayload\\EndtoEnd.json");
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.header("content-type", "Application/json");
		PostRequest.body(f);
		System.err.println("Post Request Response");
		System.out.println("*****************************************");
		Response PostResponse = PostRequest.post(baseUrl+"api/studentsDetails");
		System.out.println(PostResponse.statusCode());
		System.out.println(PostResponse.asPrettyString());
		
		String studentid= PostResponse.jsonPath().getString("id");
		
		System.out.println("Get request Response...............");
		System.out.println("************************************");
		
		Response GetResponse = RestAssured.get(baseUrl+"api/studentsDetails/"+studentid);
		System.out.println(GetResponse.statusCode());
		System.out.println(GetResponse.asPrettyString());
		
		System.out.println("Put Request Response");
		System.out.println("***************************");
		
		File jsonbody =new File("C:\\C-Drive\\hanveth\\AutomationTesting\\src\\RequestPayload\\EndtoEndPuttest");
		
		 RequestSpecification PutRequest= RestAssured.given();
		 PutRequest.header("content-type", "Application/json");
		 PutRequest.body(jsonbody);
		 Response PutResponse = PutRequest.put(baseUrl+"api/studentsDetails/10385834");
		 System.out.println(PutResponse.getStatusCode());
		 System.out.println(PutResponse.asPrettyString());
		 
		 
	}

}
