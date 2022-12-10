package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest {

	@Test
	public void Test1() {
		
    	Map<String,Object> MapObj = new HashMap<String,Object>();
    	MapObj.put("name", "Sumita");
    	MapObj.put("salary", "7500");
    	
    	RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(MapObj).patch("employees/2");
		
		System.out.println(response.getBody().asString());
		int responseCode = response.getStatusCode();
		
		Assert.assertEquals(200, responseCode);
		
	}
}
