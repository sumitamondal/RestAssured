package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body("{\r\n"
				+ "    \"name\": \"Sohan\",\r\n"
				+ "    \"salary\": \"7000\"\r\n"
				+ "}").post("employees/create");
		
		System.out.println(response.getBody().asString());
		int responseCode = response.getStatusCode();
		
		Assert.assertEquals(201, responseCode);
	}
}
