package ashokRestAssured_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetcallwithQueryParams {
	
	String BaseUrl = "https://reqres.in/";
	String path = "api/users/";
	RequestSpecification requestSpec;
	@BeforeMethod
	public void setConfiguration() {
	 requestSpec = RestAssured.given();
		requestSpec.baseUri(BaseUrl);
		requestSpec.basePath(path);
		requestSpec.queryParam("page", "2");
		requestSpec.log().all();
	}
	
	@Test
	public void addingthePathParams() {

		Response getRespone = requestSpec.get();
		System.out.println(getRespone.getStatusCode());
		System.out.println(getRespone.asPrettyString());
		
		Assert.assertEquals(getRespone.jsonPath().getString("data.first_name[0]"), "Michael");
 
	}
}
