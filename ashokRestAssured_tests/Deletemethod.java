package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Deletemethod {
	
	@Test
	public void deleteStudentdata() {
		
		String DeleteUrl = "https://thetestingworldapi.com/api/studentsDetails/10381582";
		
		Response DeleteResponse = RestAssured.get(DeleteUrl);
		System.out.println(DeleteResponse.statusCode());
		System.out.println(DeleteResponse.asPrettyString());
	}

}
