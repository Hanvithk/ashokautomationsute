package ashok_restassured_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getcall_Assertion_TC2 {

	String geturl = "https://thetestingworldapi.com/api/studentsDetails/10497844";
	@Test
	public void TC001() {
		
	Response getresponse =RestAssured.get(geturl);
	
	System.out.println(getresponse.getStatusCode());
	
	System.out.println(getresponse.getHeaders());
	System.out.println(getresponse.getHeader("Content-Type"));
	System.out.println(getresponse.asPrettyString());
	
	Assert.assertEquals(getresponse.getStatusCode(), 200);
	Assert.assertEquals(getresponse.getHeader("Content-Type"), "application/json; charset=utf-8");
	Assert.assertTrue(getresponse.asString().contains("true"));
	Assert.assertEquals(getresponse.jsonPath().getString("data.middle_name"),"Cali" ); 
	
	
	}
}
