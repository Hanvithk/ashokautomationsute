package ashokRestAssured_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Endto_End_TestCase_post_Get_Put_Delete {
	String BaseUrl    = "https://thetestingworldapi.com/";
	
	String firstname  = "ashok";
	String middlename = "A";
	String lastname   = "krunal";
	String dob        = "12/12/2000";
	
	//String postRequestbody = "{ \"id\\\":1,  \"first_name\": \"FNAME\",  \"middle_name\": \"MNAME\",  \"last_name\": \"LNAME\",  \"date_of_birth\": \"DOB\"  }";
	
	@Test
	public void EndtoEndTestCase() {
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.body("{\"id\":10382088,\"first_name\":\"Test\",\"middle_name\":\"ing\",\"last_name\":\"Qa\",\"date_of_birth\":\"11-11-2000\"}");
		PostRequest.header("content-type", "Application/json");
	 
		System.out.println("This is a post call");
		System.out.println("**********************************************");
		Response postresponse = PostRequest.post(BaseUrl+"api/studentsDetails");
		System.out.println(postresponse.statusCode());
		System.out.println(postresponse.asPrettyString());
		
		String studentid = postresponse.jsonPath().getString("id");
		 
		// Get request*********************
		Response getresponse = RestAssured.get(BaseUrl+"api/studentsDetails/"+studentid);
		System.out.println(getresponse.statusCode());
		System.out.println(getresponse.asPrettyString());
		
		Assert.assertEquals(getresponse.jsonPath().getString("data.first_name"),"Test");
		Assert.assertEquals(getresponse.jsonPath().getString("data.middle_name"),"ing");
		Assert.assertEquals(getresponse.jsonPath().getString("data.last_name"),"Qa");
		
		// put request*********************************
		RequestSpecification putrequest = RestAssured.given();
		putrequest.body("{\"id\":10382088,\"first_name\":\"Test\",\"middle_name\":\"ing\",\"last_name\":\"Tester\",\"date_of_birth\":\"11-11-2000\"}");
		putrequest.header("content-type", "Application/json");
		
		Response putresponse = putrequest.put(BaseUrl+"api/studentsDetails/"+studentid);
		System.out.println(putresponse.statusCode());
		System.out.println(putresponse.asPrettyString());
		
		// Delete request*********************
		
		Response Deleteresponse = RestAssured.delete(BaseUrl+"api/studentsDetails/"+studentid);
		System.out.println(Deleteresponse.statusCode());
		System.out.println(Deleteresponse.asPrettyString());
	
	}
	
	

}
