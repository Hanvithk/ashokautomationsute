package ashokRestAssured_tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Chainning {
	String BaseUrl = "https://thetestingworldapi.com/";
	
	@Test
	public void PostRequestChain() {
		
		File f=new File("C:\\C-Drive\\hanveth\\AutomationTesting\\src\\RequestPayload\\Studentdata2.json");
		
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.header("content-type", "Application/json");
		PostRequest.body(f);
		PostRequest.log().all();
		
		System.out.println("Post request method");
		System.out.println("***************************************");
		Response postresponse =  PostRequest.post(BaseUrl+"api/studentsDetails");
		System.out.println(postresponse.statusCode());
		System.out.println(postresponse.asPrettyString());
		
		String studentid = postresponse.jsonPath().getString("id");
		
		Response getresponse = RestAssured.get(BaseUrl+"api/studentsDetails/"+studentid);
		System.out.println(getresponse.getStatusCode());
		System.out.println(getresponse.asPrettyString());
		
		
	}

}
