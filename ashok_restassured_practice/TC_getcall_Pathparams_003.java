package ashok_restassured_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_getcall_Pathparams_003 {
	
	String baseUrl= "https://thetestingworldapi.com/";
	String basepath = "api/studentsDetails";
	@Test
	public void getcall() {
		
		RequestSpecification getrequest =RestAssured.given();
		getrequest.baseUri(baseUrl);
		getrequest.basePath(basepath);
		getrequest.pathParam("ID", "10507867");
		
		Response getresponse=getrequest.get("{ID}");
		System.out.println(getresponse.getStatusCode());
		System.out.println(getresponse.asPrettyString());
		
		Assert.assertEquals(getresponse.jsonPath().getString("data.first_name"), "RossTest");
		
		
	}

}
