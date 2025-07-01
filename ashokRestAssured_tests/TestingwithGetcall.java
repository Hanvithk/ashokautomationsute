package ashokRestAssured_tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestingwithGetcall {
	
	String GetUrl = "https://thetestingworldapi.com/api/studentsDetails/10389172";
	String PostbaseUrl = "https://gorest.co.in/public/v2/users";
	String AuthToken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
	String GetbaseUrl = "https://thetestingworldapi.com/";
	
	@Test
	public void getstudentdata() {
		 Response GetResponse =RestAssured.get(GetUrl);
		 System.out.println(GetResponse.getStatusCode());
		 System.out.println(GetResponse.asPrettyString());
		 
		 Assert.assertEquals(GetResponse.statusCode(), 200);
		 Assert.assertEquals(GetResponse.jsonPath().getString("data.first_name"),"Wilbert");
	}
	
	@BeforeMethod
	public void Postmethod() {
		File f=new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\PostwithGorest.json");
				
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.header("content-type", "Application");
		PostRequest.headers("Authorization", AuthToken ).contentType(ContentType.JSON).body(f);
		
		Response PostResponse =PostRequest.post(PostbaseUrl);
		System.out.println(PostResponse.statusCode());
		System.out.println(PostResponse.asPrettyString());
		
		String studentid = PostResponse.jsonPath().getString("id");
		
		Response GetResponse =RestAssured.get(GetbaseUrl+"api/studentsDetails/"+studentid);
		System.out.println(GetResponse.getStatusLine());
		System.out.println(GetResponse.asPrettyString());
	}

}
