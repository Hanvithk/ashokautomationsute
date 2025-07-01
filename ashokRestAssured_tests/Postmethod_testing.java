package ashokRestAssured_tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postmethod_testing {
	
		String PostUrl = "https://gorest.co.in/public/v2/users";
		String AuthToken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
		String DeleteUrl = "https://gorest.co.in/public/v2/users/7381277";
	
		String PutUrl = "https://gorest.co.in/public/v2/users";
@Test
public void Postmethod() {
	File jsonbody=new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\StudentPostcall.json");
	
	RequestSpecification PostRequest=RestAssured.given();
	PostRequest.header("content-type", "Application/json");
	PostRequest.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(jsonbody);
	PostRequest.log().all();
	
	System.out.println("Post Request Response");
	System.out.println("*****************************************");
	Response PostResponse=PostRequest.post(PostUrl);
	System.out.println(PostResponse.statusCode());
	System.out.println(PostResponse.asPrettyString());
	
	/*
	System.out.println("Delete Request response");
	System.out.println("*********************************************");
	
	Response DeleteResponse =RestAssured.delete(DeleteUrl);
	System.out.println(DeleteResponse.getStatusCode());
	System.out.println(DeleteResponse.asPrettyString());
	*/
}
}
