package ashokRestAssured_tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003PostcallwithAthantication {
	
	String BaseUrl = "https://gorest.co.in/";
	String AuthToken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
	
	@Test
	public void Athorizationtest() {
		
		File jsonbody=new File("C:\\C-Drive\\hanveth\\AutomationTesting\\src\\RequestPayload\\Madhu.json");
		
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.header("content-type", "Application/json");
		PostRequest.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(jsonbody);
		PostRequest.log().all();
		
		Response PostResponse= PostRequest.post(BaseUrl+"public/v2/users");
		System.out.println(PostResponse.getStatusCode());
		System.out.println(PostResponse.asPrettyString());
		System.out.println(PostResponse.header("Headers"));
		
		File f=new File("C:\\C-Drive\\hanveth\\AutomationTesting\\src\\RequestPayload\\MadhuUpdat.json");
		
		RequestSpecification PutRequest = RestAssured.given();
		PutRequest.header("content-type", "Application/json");
		PostRequest.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(f);
		Response PutResponse = PutRequest.put(BaseUrl+"public/v2/users/7363851");
		
		System.out.println(PutResponse.getStatusCode());
		System.out.println(PutResponse.asPrettyString());
		
		
		
		
		
		
	}

}
