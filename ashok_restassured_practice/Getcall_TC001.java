package ashok_restassured_practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getcall_TC001 {

	String geturl = "https://thetestingworldapi.com/api/studentsDetails/10497844";
	@Test
	public void Tc001() {
		
	Response getresponse =RestAssured.get(geturl);
	
	System.out.println(getresponse.getStatusCode());
	
	//System.out.println(getresponse.getHeaders());
	System.out.println(getresponse.getHeader("Content-Type"));
	System.out.println(getresponse.asPrettyString());
	
	}
}
