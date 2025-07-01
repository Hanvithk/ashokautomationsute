package ashokRestAssured_tests;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class AuthTokenwithPostcall {
	
	String PostUrl = "https://gorest.co.in/public/v2/users";
	
	String AuthToken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
	
	public void Authtoken() {
		
		File jsonbody = new File("C:\\C-Drive\\hanveth\\AutomationTesting\\src\\RequestPayload\\ashok.json");
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.header("content-type", "Application.json");
		PostRequest.header("Authorization" ,AuthToken).contentType(ContentType.JSON).body(jsonbody);
		
		Response PostResponse = PostRequest.post(PostUrl);
		System.out.println(PostResponse.getStatusCode());
		System.out.println(PostResponse.asPrettyString());

	}

}
