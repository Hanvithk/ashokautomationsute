package ashok_restassured_practice;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postwithjsonbody {
	
	String PostUrl = "https://thetestingworldapi.com/api/studentsDetails";
	
	
	public void tc001() {
		
		File jsonbody = new File("C:\\Users\\91767\\git\\repository\\AutomationTesting\\src\\RequestPayload\\newpost.json");
		RequestSpecification PostReq=RestAssured.given();
		PostReq.header("Content-type", "Application/Json");
		PostReq.body(jsonbody);
		PostReq.log().all();
		
		Response Postresponse=PostReq.post(PostUrl);
		System.out.println(Postresponse.asPrettyString());
		System.out.println(Postresponse.getStatusCode());
        
	}
	
	@Test
	public void tc002() {   // "path/to/file.txt"
		
		File file = new File("C:\\\\Users\\\\91767\\\\git\\\\repository\\\\AutomationTesting\\\\src\\\\RequestPayload\\\\newpost.json");
		

		Response response = RestAssured
		    .given()
		    .header("Content-type", "Application/json")
		    .multiPart("file", file)
		    .post(PostUrl);

		System.out.println(response.getStatusCode());

	}

}
