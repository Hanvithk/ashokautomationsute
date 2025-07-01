package ashokRestAssured_tests;


import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_001 {

	String baseUrl = "https://reqres.in/api/users/2";
	String BaseUrl = "https://thetestingworldapi.com/";
	String basepath = "api/studentsDetails";
	String URL = "https://gorest.co.in/public/v2/users";
	String PutUrl = "https://gorest.co.in/public/v2/users";
	String AuthToken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
	
	@Test 
	public void getcall() {
		
		Response GetResponse = RestAssured.get(baseUrl);
		System.out.println(GetResponse.asPrettyString());
		System.out.println(GetResponse.getStatusCode());
		
		Assert.assertEquals(GetResponse.getStatusCode(), 200);
		//Assert.assertEquals(GetResponse.jsonPath().getString("first_name"), "Janet");
		//Assert.assertEquals(GetResponse.jsonPath().getString("last_name"), "Weaver");
		Assert.assertTrue(GetResponse.asString().contains("Weaver"));
	}
	@Test
	public void getcallwithpathparams() {
		RequestSpecification getRequest = RestAssured.given();
		getRequest.baseUri(BaseUrl);
		getRequest.basePath(basepath);
		
		Response GetResponse =getRequest.get();
		System.out.println(GetResponse.asPrettyString());
		System.out.println(GetResponse.getTime());
		System.out.println(GetResponse.getStatusCode());
		
	}
	@Test
	public void postcall() {
		
		File f=new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\newstudentadta");
		RequestSpecification PostReq =RestAssured.given();
		PostReq.header("content-Type", "Appliction/json");
		PostReq.header("Authorization",  AuthToken).contentType(ContentType.JSON).body(f);
		
		Response PostRes =PostReq.post(URL);
		System.out.println(PostRes.asPrettyString());
		System.out.println(PostRes.getStatusCode());
		
	}
	@Test
	public void putcall() {
		File body=new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\putnewstudent");
		
		RequestSpecification PutReqs =RestAssured.given();
		PutReqs.header("content-type","Application/json");
		PutReqs.headers("Autorization", AuthToken).contentType(ContentType.JSON).body(body);
		
		Response PutRes =PutReqs.put(PutUrl);
		System.out.println(PutRes.asPrettyString());
		System.out.println(PutRes.getStatusCode());
		
		
	}
}
