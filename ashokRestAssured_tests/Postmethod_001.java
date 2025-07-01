package ashokRestAssured_tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class Postmethod_001 {

	String baseurl = "https://thetestingworldapi.com/";
	
	
	public void postmethod() {
		File f=new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\post.json");
		
		RequestSpecification PostRequest=RestAssured.given();
		PostRequest.header("content-type", "Application/json");
		PostRequest.body(f);
		

		Response PostResponse =PostRequest.post(baseurl+"api/studentsDetails");
		System.out.println(PostResponse.asPrettyString());
		
		String studentid= PostResponse.jsonPath().getString("id");
		
		Response GetResponse=RestAssured.get(baseurl+"api/Students/"+studentid);
		System.out.println(GetResponse.asPrettyString());
		System.out.println(GetResponse.getStatusCode());
		
		
		
	}
}
