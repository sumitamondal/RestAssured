package restAPIXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XMLExample {

	@Test
	public void Test1() {
		
		RestAssured.baseURI = "https://chercher.tech/sample/api/books.xml";
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		System.out.println(response.getBody().asString());
		
		NodeChildrenImpl AllBooks = response.then().extract().path("bookstore.book.title");
		System.out.println(AllBooks);
		System.out.println("The first book is " + AllBooks.get(0));
		System.out.println("The second book is " + AllBooks.get(1));
		
		System.out.println("The first book language is " + AllBooks.get(0).getAttribute("lang"));
		System.out.println("The second book language is " + AllBooks.get(1).getAttribute("lang"));
	}
}
