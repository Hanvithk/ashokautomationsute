package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Chaining {
	
	String BaseUrl = "https://thetestingworldapi.com/";
	
	@Test
	public void PostGetPutDelete() {
		RequestSpecification PostRequest = RestAssured.given();
		PostRequest.body("{\"id\":10383283,\"first_name\":\"Mahrish\",\"middle_name\":\"Mrug\",\"last_name\":\"Shh\",\"date_of_birth\":\"10/12/2002\"}");
		PostRequest.header("Content-type", "Application/json");
		
		System.out.println("Post Request Response");
		System.out.println("***********************************************");
		Response PostResponse = PostRequest.post(BaseUrl+"api/studentsDetails");
		System.out.println(PostResponse.asPrettyString()); 
		System.out.println(PostResponse.statusCode());
		
		String studentid = PostResponse.jsonPath().getString("id");
		
		Response getresponse = RestAssured.get(BaseUrl+"api/studentsDetails/"+studentid);
        System.out.println(getresponse.asPrettyString());
        System.out.println(getresponse.getStatusCode());
        
        RequestSpecification PutRequest = RestAssured.given();
        PutRequest.body("{\"id\":10383283,\"first_name\":\"Mahrish\",\"middle_name\":\"Mrug\",\"last_name\":\"Sing\",\"date_of_birth\":\"10/12/2002\"}");
        PutRequest.header("Content-type", "Application/json");
        
        Response PutResponse = PutRequest.put(BaseUrl+"api/studentsDetails/"+studentid);
        System.out.println(PutResponse.asPrettyString());
        System.out.println(PutResponse.getStatusCode());
		
        Response DeleteResponse = RestAssured.delete(BaseUrl+"api/studentsDetails/"+studentid);
        System.out.println(DeleteResponse.asPrettyString());
        System.out.println(DeleteResponse.statusCode());
		
	}

}
