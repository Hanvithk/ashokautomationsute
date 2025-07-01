package ashok_restassured_practice;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Practice_001 {
	
	String geturl = "https://thetestingworldapi.com/api/studentsDetails";
	String BaseUrl = "https://reqres.in/";
	String path = "api/users/";
	String AuthToken = "Bearer 381c6d4e973983ea6dcc60023c5a01bd3d083ca78047b5237334f32df31f7f83";
	String posturl = "https://gorest.co.in/public/v2/users";
	
	@Test(priority = 3)
	public void getmethod() {
		
		Response getres =RestAssured.get(geturl);
		System.out.println(getres.asPrettyString());
		System.out.println(getres.getStatusCode());
	}
	
	@Test(priority = 2)
	public void getpathparams() {
		RequestSpecification getreq =RestAssured.given();
		getreq.baseUri(BaseUrl);
		getreq.basePath(path);   
		getreq.pathParam("ID", "2");
		
		Response getresponse =getreq.get("{ID}");
		System.out.println(getresponse.asPrettyString());
		System.out.println(getresponse.getStatusCode());
		Assert.assertEquals(getresponse.getStatusCode(), 200);
		Assert.assertEquals(getresponse.jsonPath().getString("data.first_name"), "Janet");
		Assert.assertEquals(getresponse.jsonPath().getString("data.last_name"), "Weaver");
	}
	
	@Test(priority = 1)
	public void postmethod() {
		File f = new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\postcall.json");
		RequestSpecification PostReq =RestAssured.given();
		PostReq.header("Content-type", "Application-Json");
		PostReq.header("Authoraization", AuthToken).contentType(ContentType.JSON).body(f);
		
		Response PostResp  =PostReq.post(posturl);
		System.out.println(PostResp.asPrettyString());
		System.out.println(PostResp.getStatusCode());
		System.out.println(PostResp.getHeaders());
		System.out.println(PostResp.getHeader("Content-Type"));
		System.out.println(PostResp.prettyPrint());
		Assert.assertEquals(PostResp.jsonPath().getString("name"), "karetiHanvith");
	}

}
