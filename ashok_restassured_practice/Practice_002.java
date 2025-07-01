package ashok_restassured_practice;

import java.io.File;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Practice_002 {

	String geturl = "https://thetestingworldapi.com/api/studentsDetails";
	String baseurl = "https://thetestingworldapi.com/";
	String basepath = "api/studentsDetails";
	String AuthToken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
	String PostUrl = "https://thetestingworldapi.com/api/studentsDetails";
	
	@Test(enabled = false)
	public void getmethod() {
		Response gtresponse =RestAssured.get(geturl);
		System.out.println(gtresponse.getStatusCode());
		System.out.println(gtresponse.asPrettyString());
	}
	
	@Test(priority = 2)
	public void getpathparams() {
		
		RequestSpecification getrequest =RestAssured.given();
		getrequest.baseUri(baseurl);
		getrequest.basePath(basepath);
		getrequest.pathParam("ID", "10495551");
		
		Response getresponse =getrequest.get("{ID}");
		System.out.println(getresponse.asPrettyString());
		System.out.println(getresponse.getStatusCode());
	}
	
	@Test(priority = 1)
	public void Postmethod() {
		
		File f = new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\PostRequest.json");
		
		RequestSpecification PostRequest =RestAssured.given();
		PostRequest.header("Content-type","Application/json");
		PostRequest.body(f);
		
		Response PostResponse =PostRequest.post(PostUrl);
		System.out.println(PostResponse.getStatusCode());
		System.out.println(PostResponse.asPrettyString());
		Assert.assertEquals(PostResponse.jsonPath().getString("first_name"), "Kareti");
		Assert.assertEquals("Kareti", "Kareti");

	}
}
