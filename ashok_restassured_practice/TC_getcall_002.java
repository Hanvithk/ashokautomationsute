package ashok_restassured_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_getcall_002 {
	
	String baseUrl= "https://thetestingworldapi.com/";
	String basepath = "api/studentsDetails";
	@Test
	public void getcall() {
		
		RequestSpecification getrequest =RestAssured.given();
		getrequest.baseUri(baseUrl);
		getrequest.basePath(basepath);
		
		Response getresponse=getrequest.get();
		System.out.println(getresponse.getStatusCode());
		System.out.println(getresponse.asPrettyString());
		
	}

}
