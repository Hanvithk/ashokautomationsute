package ashokRestAssured_tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCallwithAthorization {

	String PostUrl = "https://gorest.co.in/";
	String AuthToken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
	
	@Test
	public void Athentication() {
		
		File f=new File("C:\\C-Drive\\hanveth\\AutomationTesting\\src\\RequestPayload\\Responsebody.json");
		
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.header("content-type", "Application/json");
		PostRequest.headers("Authorization", AuthToken ).contentType(ContentType.JSON).body(f);
		
		Response PostResponse = PostRequest.post(PostUrl+"public/v2/users");
		System.out.println(PostResponse.getStatusCode());
		System.out.println(PostResponse.asPrettyString());
		
		/*
		String studentid = PostResponse.jsonPath().getString("id");
		Response GetResponse = RestAssured.get(PostUrl+"public/v2/users/"+studentid);
		System.out.println(GetResponse.getStatusCode());
		System.out.println(GetResponse.asPrettyString());
		*/
	}
}
