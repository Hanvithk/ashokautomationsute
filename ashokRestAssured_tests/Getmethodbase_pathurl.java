package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getmethodbase_pathurl {

	String baseurl = "https://thetestingworldapi.com/";
	String path = "api/studentsDetails";
	
	@Test
	public void getbaseandpath() {
		RestAssured.baseURI=baseurl;
		RestAssured.basePath= path;
		
		 Response GetRespone= RestAssured.get();
		 System.out.println(GetRespone.statusCode());
		 System.out.println(GetRespone.asPrettyString());
		 
	}
	
}
