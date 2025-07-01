package ashokRestAssured_tests;


import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postcall {
	
	//String PostUrl = "https://thetestingworldapi.com/api/studentsDetails"; 
	
	String Post = "https://gorest.co.in/public/v2/users";
	String AuthToken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
	
	@Test
	public void postmathod() {
		
		RequestSpecification postrequest = RestAssured.given();
		
		File jsonbody=new File("C:\\C-Drive\\hanveth\\AutomationTesting\\src\\RequestPayload\\Persondata.json");
		
		postrequest.header("content-type", "Application/json");
		
		postrequest.header("Authorization", AuthToken).contentType(ContentType.JSON).body(jsonbody);
		
		 Response PostResponse = postrequest.post(Post);
		 System.out.println(PostResponse.asPrettyString());
		 System.out.println(PostResponse.statusCode());
		
		 Assert.assertEquals(PostResponse.statusCode(), 201);
		 Assert.assertEquals(PostResponse.jsonPath().getString("name"), "Smitrarai");
		 Assert.assertTrue(PostResponse.asString().contains("female"));
		
	}

}
