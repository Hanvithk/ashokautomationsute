package ashok_restassured_practice;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class FilefromTxtFile {
	
	public void TC001() throws IOException {
		
		String localFilePath = "C:\\C-Drive\\ashokrequest.txt";
		URI filePath;
		//String expectedContent  = new String (Files.readAllBytes(Paths.get(filePath)));
		
		RequestSpecification GetRequest =RestAssured.given();
		//GetRequest.baseUri(expectedContent);
		
	}
}
