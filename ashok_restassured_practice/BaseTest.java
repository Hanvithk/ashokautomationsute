package ashok_restassured_practice;

public class BaseTest {

	String PostBaseUrl= "https://gorest.co.in/public/v2/users";
	String requestbody = "\r\n"
			+ "{\r\n"
			+ "  \"id\": 1,\r\n"
			+ "  \"name\": \"kareti Ashok\",\r\n"
			+ "  \"email\": \"karetiAshok123@gmail.com\",\r\n"
			+ "  \"gender\": \"male\",\r\n"
			+ "  \"status\": \"active\"\r\n"
			+ "}\r\n"
			+ "";
	
	String Authtoken = "Bearer 60d0b06b5263f0688d2dafa9712debcc035fbd821d9c6a3230836ca2eb323ac1";
	
}
