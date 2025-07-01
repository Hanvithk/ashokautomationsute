package ashok_restassured_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getcallwithpath {
	
	String baseurl = "https://gorest.co.in";
	String path = "/public/v2/users/";
	
	@Test(enabled = false)
	public void tc001() {
		
		RestAssured.baseURI=baseurl;
		RestAssured.basePath=path;
		
		Response GetResponse   =RestAssured.get();
		System.out.println(GetResponse.asPrettyString());
		System.out.println(GetResponse.statusCode());
		
	}
	
	@Test
	public void tc002() {
		
		RequestSpecification getrequest =RestAssured.given();
		getrequest.baseUri(baseurl);
		getrequest.basePath(path);
		getrequest.pathParam("ID", 6942480);
		System.out.println(getrequest.log().all());
		
		Response getresponse =getrequest.get("{ID}");
		System.out.println(getresponse.asPrettyString());
		System.out.println(getresponse.getStatusCode());
		
		Assert.assertEquals(getresponse.jsonPath().getString("id"), "6942480");
		Assert.assertTrue(getresponse.asString().contains("Vaishnavi Kakkar DC"));
		System.out.println(getresponse.getHeaders());
		
		
	}

}
