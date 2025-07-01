package ashokRestAssured_tests;

import java.io.File;

import org.apache.http.client.protocol.RequestAuthCache;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class PostwithJsonbody {
	
	String PostUrl = "https://thetestingworldapi.com/api/studentsDetails";
	//String Token = " ";
	//String authToken = "Bearer "+ Token;
	RequestSpecification Request;
	
	@BeforeMethod
	public void setConfiguration() {
		
		File Json=new File("C:\\C-Drive\\hanveth\\AutomationTesting\\src\\RequestPayload\\Studentdata.json");
		
		//.header(headerName: "Authorization",authToken);
		Request = RestAssured.given();
		Request.header("content-type", "Application/json");
		Request.body(Json);
		System.out.println(Request.log().all()); 
		
	}
	
	public void createStudentdata() {
		Response postresponse = Request.post(PostUrl);
		System.out.println(postresponse.asPrettyString());
		System.out.println(postresponse.statusCode());
		
	}

}
