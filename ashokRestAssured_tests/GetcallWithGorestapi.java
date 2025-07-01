package ashokRestAssured_tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetcallWithGorestapi {
	
	String GetUrl = "https://gorest.co.in/public/v2/users/6940665";
	
	@Test
	public void GetcallTest() {
		Response GetResponse = RestAssured.get(GetUrl);
		System.out.println(GetResponse.asPrettyString());
		System.out.println(GetResponse.getStatusCode());
	}

}
