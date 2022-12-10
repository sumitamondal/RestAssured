package restAPI;

import java.io.File;
import java.io.IOException;
//import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithFile {

	@Test
	public void Test1() throws IOException {
		
		
		//byte[] datafile = Files.readAllBytes(Paths.get("data1.json"));
		
		File datafile = new File("data1.json");
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(datafile).post("employees/create");
		
		System.out.println(response.getBody().asString());
		
		int responseCode = response.getStatusCode();
				Assert.assertEquals(201, responseCode);
	}
}
