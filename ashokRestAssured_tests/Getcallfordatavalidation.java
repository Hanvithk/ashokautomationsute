package ashokRestAssured_tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getcallfordatavalidation {
	String BaseUrl = "https://thetestingworldapi.com/api/studentsDetails";
	
	@Test
	public void getdata() {
		
		Response getresponse = RestAssured.get(BaseUrl);
		System.out.println(getresponse.statusCode()); 
		System.out.println(getresponse.asPrettyString());
		Assert.assertEquals(getresponse.statusCode(), 200);
		//Assert.assertEquals(getresponse.jsonPath().getString("first_name[0]"), "Mrs");
		Assert.assertTrue(getresponse.asString().contains("Salman"));
	}

}
