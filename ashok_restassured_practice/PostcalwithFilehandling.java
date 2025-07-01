package ashok_restassured_practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostcalwithFilehandling {
	
	String posturl = "https://thetestingworldapi.com/api/studentsDetails";
	@Test
	public void tc001() throws IOException {
		
		String inputData= "";
		File jsonbody = new File("C://Users//91767//Desktop//ashok//fileclase.txt");
		FileReader fr= new FileReader(jsonbody);
		BufferedReader br = new BufferedReader(fr);
		String jsoncontent =br.readLine();
		
		while (jsoncontent!=null) {
			inputData = inputData+ jsoncontent;
			jsoncontent =br.readLine();
		}
		RequestSpecification PostReq = RestAssured.given();
		PostReq.header("Content-Type", "Application/Json");
		PostReq.body(inputData);
		
		Response postresponse = PostReq.post(posturl);
		System.out.println(postresponse.asPrettyString());
		
	}

}
