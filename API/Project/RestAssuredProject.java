package project;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredProject {
	RequestSpecification requestSpec;

	int id;
	String ssh="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCIkzrkUV+dRHbrBvgOD4CXaNQS8hCVobXmpf2BulzcTWPY1UgowR1EAdTamPaEhqdMgC0oYMkYKGjZGm+5F4EFmn6I8SjLt9B8s1JPBGRgShXXxO+vCe67HlZKXCnnAecX3QCuf3qf0XC5PTdAWObbm0FGzF7UtLMaQ7IntzoRRlYJsaio6CeH4QEmMAyaVzxuLfkROujdm2/oZXwwl5TfX/x3XQoSVdRj/pT0aw1xwJuaOKRir7eSctZ/3MPkgdURRAygdDmIFAH2ri94pQm4baAQlbjNvHugaDGS9bN6Bj9QVuQkg4sK0RvkIR8J1WefzzYyPw0YK7x+iDV7zSOp";

	@BeforeClass
	public void setUp() {
		String token ="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";
		requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", "Bearer "+token)
				.setBaseUri("https://api.github.com")
				.build();
	}
	@Test(priority=1)

	public void addKeys() {
		String reqBody = "{"
				+ "\"title\": \"TestAPIKey\","
				+ "\"key\":\""+ssh+"\""
				+ "}";
		Response response = given().spec(requestSpec)
				.body(reqBody)
				.when().post("/user/keys");

		id = response.then().extract().path("id");
		System.out.println(id);
		response.then()
		.statusCode(201);
	}
	@Test(priority=2)
	public void getkeys() {
		Response response = given().spec(requestSpec)
				.when().get("/user/keys");

		System.out.println( response.then().log().all());

		response.then()
		.statusCode(200);
	}

	@Test(priority=3)
	public void deletekeys() { 
		Response response =
				given().spec(requestSpec) 
				 .pathParam("keyId", id)
				.when().delete("/user/keys/{keyId}"); 
		System.out.println( response.then().log().all()); 
		response.then()
		.statusCode(204);
		}

}