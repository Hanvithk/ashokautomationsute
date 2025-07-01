package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Putmethod {
	
	@Test
	public void updatethedata() {
		String PutUrl = "https://thetestingworldapi.com/api/studentsDetails/10381582";
		
		RequestSpecification PutRequest = RestAssured.given();
		PutRequest.body("{\"id\":10381582,\"first_name\":\"B\",\"middle_name\":\"Ram\",\"last_name\":\"Raoo\",\"date_of_birth\":\"12/12/2001\"}");
		PutRequest.header("content-type", "Application/json");
		 
		 Response PutResponse = PutRequest.put(PutUrl);
		 System.out.println(PutResponse.statusCode());
		 System.out.println(PutResponse.headers());
		 System.out.println(PutResponse.asPrettyString());
		
		
	}

}
