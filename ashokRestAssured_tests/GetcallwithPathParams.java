package ashokRestAssured_tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetcallwithPathParams {
	
	String BaseUrl = "https://reqres.in/";
	String path = "api/users/";
	String Url = "https://reqres.in/api/users";
	String s= "This is Testing World";
	
	@Test
	public void addingthePathParams() {
		
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri(BaseUrl);
		requestSpec.basePath(path);
		requestSpec.pathParam("ID", "2" );
		
		Response getRespone = requestSpec.get("{ID}");
		System.out.println(getRespone.getStatusCode());
		System.out.println(getRespone.asPrettyString());
		
		System.out.println(Url.toUpperCase());
		System.out.println(Url.toLowerCase());
		System.out.println(Url.length());
		System.out.println(Url.charAt(20));
		System.out.println(Url.replace("users", ""));
		System.out.println(Url.length() - Url.replace("r", "").length());
		System.out.println(BaseUrl+path);
		System.out.println(Url.substring(2, 20));
		System.out.println(Url.substring(3));
		
		if(Url.contains("users")) {
			System.out.println("Found");
		}
		else {
			System.out.println("Not Found");
		}
		
		Assert.assertEquals(getRespone.jsonPath().getString("data.email"), "janet.weaver@reqres.in" );
		Assert.assertEquals(getRespone.jsonPath().getString("data.first_name"), "Janet");
		Assert.assertEquals(getRespone.statusCode(), 200);
		Assert.assertEquals(getRespone.jsonPath().getString("data.avatar"), "https://reqres.in/img/faces/2-image.jpg");
 
	}
	@AfterMethod
	public void stringmethods() {
		String arr[]=s.split(" ");
		for(String a: arr) {
			System.out.println(a);
		}
	}
	
}
