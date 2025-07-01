package ashokRestAssured_tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Postmethod {
	
	String PostUrl = "https://thetestingworldapi.com/api/studentsDetails";
	
	@Test
	public void creatinthenewStudentdata() {
		
		
		RequestSpecification postrequest =  RestAssured.given();
		postrequest.body("{\"id\":1,\"first_name\":\"A\",\"middle_name\":\"Ram\",\"last_name\":\"Rao\",\"date_of_birth\":\"12/12/2000\"}");
		postrequest.header("content-type", "Application/json");
		
	    Response postresponse = postrequest.post(PostUrl);
	   System.out.println(postresponse.statusCode()); 
	   System.out.println(postresponse.asPrettyString());
	   
	   Assert.assertEquals(postresponse.jsonPath().getString("middle_name"), "Ram");
	   Assert.assertTrue(postresponse.asString().contains("12/12/2000"));
	   Assert.assertEquals(postresponse.statusCode(), 201);
	    
	}

}
