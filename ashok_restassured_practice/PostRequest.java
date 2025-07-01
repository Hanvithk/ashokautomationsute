package ashok_restassured_practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest extends BaseTest {

	@Test
	public void PostTest() {
		
		RequestSpecification PostRequest =RestAssured.given();
		PostRequest.baseUri(PostBaseUrl);
		PostRequest.header("Authorization", "Authtoken").contentType(ContentType.JSON).body(requestbody);
		PostRequest.log().all();
		
		Response PostResponse=PostRequest.post();
		System.out.println(PostResponse.asPrettyString());
		System.out.println(PostResponse.getStatusCode());
	}
}
