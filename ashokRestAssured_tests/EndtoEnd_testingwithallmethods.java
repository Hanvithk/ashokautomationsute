package ashokRestAssured_tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndtoEnd_testingwithallmethods {

	String baseurl = "https://thetestingworldapi.com/";
	
	@Test 
	public void endtoendtesting() {
		
		File f=new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\EndtoendTest.json");
				
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.header("Content-type", "Application/json");
		PostRequest.body(f);
		PostRequest.log().all();
		
		System.out.println("Post Request Response");
		System.out.println("*****************************************");
		Response PostResponse = PostRequest.post(baseurl+"api/studentsDetails");
		System.out.println(PostResponse.statusCode());
		System.out.println(PostResponse.asPrettyString());
		
		System.out.println("Get Request Response");
		System.out.println("****************************************************");
		
		String studentid= PostResponse.jsonPath().getString("id");
		
		Response GetResponse =RestAssured.get(baseurl+"api/studentsDetails/"+studentid);
		System.out.println(GetResponse.getStatusCode());
		System.out.println(GetResponse.asPrettyString());
		
		System.out.println("Put Request Response");
		System.out.println("***************************************************");
		
		File jsonbody=new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\Putmethod.json");
		
		RequestSpecification PutRequest = RestAssured.given();
		PutRequest.header("content-type", "Application/json");
		PutRequest.body(jsonbody);
		
		Response PutResponse=PutRequest.put(baseurl+"api/studentsDetails/"+studentid);
		System.out.println(PutResponse.getStatusCode());
		System.out.println(PutResponse.asPrettyString());
		System.out.println(PutResponse.headers());
		
		System.out.println("Delete Request Response");
		System.out.println("********************************************");
		
		Response DeleteResponse = RestAssured.delete(baseurl+"api/studentsDetails/"+studentid);
		System.out.println(DeleteResponse.getStatusCode());
		System.out.println(DeleteResponse.asPrettyString());
		
		
		
	}
}
