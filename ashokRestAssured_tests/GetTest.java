package ashokRestAssured_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetTest {
	
	String GetUrl = "https://thetestingworldapi.com/api/studentsDetails/10383307";
	
	@Test
	public void Studentdatagetting() {
		Response GetResponse = RestAssured.get(GetUrl);
		System.out.println(GetResponse.getStatusCode());
		System.out.println(GetResponse.getHeaders());
		System.out.println(GetResponse.asPrettyString());
		System.out.println(GetResponse.getHeader("Date"));
		System.out.println(GetResponse.getHeader("Server"));
		System.out.println(GetResponse.getHeader("Content-Type"));
		
		
		Assert.assertEquals(GetResponse.jsonPath().getString("data.first_name"), "Angelina");
		Assert.assertEquals(GetResponse.getStatusCode(), 200);
	}
}
