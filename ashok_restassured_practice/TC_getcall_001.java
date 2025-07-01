package ashok_restassured_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_getcall_001 {
	
	String baseUrl= "https://thetestingworldapi.com/api/studentsDetails";
	@Test
	public void getcall() {
		
		Response getresponse=RestAssured.get(baseUrl);
		System.out.println(getresponse.asPrettyString());
		System.out.println(getresponse.statusCode());
		System.out.println(getresponse.getTime());
		
		Assert.assertTrue(getresponse.asPrettyString().contains("RossTest"));
		//Assert.assertEquals(getresponse.jsonPath().getString("first_name"), "Roopa");
	}

}
