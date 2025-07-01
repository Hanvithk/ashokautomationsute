package ashokRestAssured_tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Putmethod_testing {
String puturl = "https://gorest.co.in/public/v2/users/7381278";
String AuthToken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
	
	@Test
	public void putmethod() {
		System.out.println("Put Request Response");
		System.out.println("****************************************************");
		
		RequestSpecification PutRequest = RestAssured.given();
	     File updatebody=new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\StudentPut.json");
	     
		PutRequest .header("content-type", "Application/json");
		PutRequest .headers("Authorization", AuthToken).contentType(ContentType.JSON).body(updatebody);
		PutRequest .log().all();
		
		Response PutResponse = PutRequest.put(puturl);
		System.out.println(PutResponse.getStatusCode());
		System.out.println(PutResponse.asPrettyString());
	}
}
