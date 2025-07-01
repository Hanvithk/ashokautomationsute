package ashok_restassured_practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_Add_Studentdata {
	
	String PostUrl = "https://thetestingworldapi.com/api/studentsDetails";
	
	
	@Test
	public void createstudentdata() {
		RequestSpecification PostRequest = given();
		PostRequest.header("Content-Type", "Application/json");
        PostRequest.body("{\"id\":1,\"first_name\":\"K\",\"middle_name\":\"AA\",\"last_name\":\"Hanvith\",\"date_of_birth\":\"30/11/2023\"}");
		
        Response PostResponse =PostRequest.post(PostUrl);
        Assert.assertEquals(PostResponse.getStatusCode(), 201);
        System.out.println(PostResponse.asPrettyString());
        Assert.assertEquals(PostResponse.jsonPath().getString("last_name"), "Hanvith");
        Assert.assertTrue(PostResponse.asString().contains("AA"));
        System.out.println(PostResponse.headers());

	}
	
}
