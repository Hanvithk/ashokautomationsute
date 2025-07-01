package ashok_restassured_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Serialization {
	
	String getbaseurl= "https://thetestingworldapi.com/";
	String getbasepath = "api/studentsDetails/10512587";
	String baseUrl = "https://thetestingworldapi.com/api/studentsDetails";
	String requestbody = "{\r\n"
			+ "  \"id\": 1,\r\n"
			+ "  \"first_name\": \"kareti\",\r\n"
			+ "  \"middle_name\": \"aa\",\r\n"
			+ "  \"last_name\": \"ashok\",\r\n"
			+ "  \"date_of_birth\": \"12/12/2001\"\r\n"
			+ "}";
	
	@Test
	public void postmethod() {
		
		RequestSpecification PostResquest =RestAssured.given();
		PostResquest.baseUri(baseUrl);
		PostResquest.body(requestbody);
		PostResquest.header("content-type", "Application/Json");
		PostResquest.log().all();
		
		Response PostResponse=PostResquest.post();
		System.out.println(PostResponse.asPrettyString());
		System.out.println(PostResponse.getStatusCode());
	}
	@Test
	public void getmethod() {
		
		RequestSpecification getrequest=RestAssured.given();
		getrequest.baseUri(getbaseurl);
		getrequest.basePath(getbasepath);
		getrequest.log().all();
		
		Response getResponse=getrequest.get();
		System.out.println(getResponse.asPrettyString());
		System.out.println(getResponse.getStatusCode());
		
		Assert.assertEquals(getResponse.jsonPath().getString("first_name"),"kareti");
		Assert.assertTrue(getResponse.asString().contains("ashok"));
		
		Assert.assertEquals(getResponse.getStatusCode(), 200);
		Assert.assertEquals(getResponse.getHeader("Content-Type"), "application/json; charset=utf-8");
		Assert.assertTrue(getResponse.asString().contains("true"));
		Assert.assertEquals(getResponse.jsonPath().getString("middle_name"),"aa" ); 
		
	}

}
