package restGitHub;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRepo {

	@Test
	public void test1() {
		
		File datafile = new File("data.json");
		
		RestAssured.given()
		.auth()
		.oauth2("dummytoken")
		.baseUri("https://api.github.com")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(datafile)
		.when()
		.post("user/repos")
		.then()
		.log()
		.all()
		.statusCode(201);
		
	}
}
