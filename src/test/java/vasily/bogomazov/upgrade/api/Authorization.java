package vasily.bogomazov.upgrade.api;

import org.hamcrest.beans.HasProperty;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import vasily.bogomazov.upgrade.DTO.CredentialsBody;
import vasily.bogomazov.upgrade.DTO.LoanResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

public class Authorization {
	
	
	@Test (priority=1)
	public void restAssuredAuthorizationValidCredentials()  {
		RestAssured.config();
		RestAssured.baseURI = "https://credapi.credify.tech";
		
		CredentialsBody credentials = new CredentialsBody();
		credentials.setUsername("coding.challenge.login@upgrade.com");
		credentials.setPassword("On$3XcgsW#9q");
		credentials.setRecaptchaToken("coding-challenge");
		LoanResponse response = given()
				.contentType(ContentType.JSON)
				.header("x-cf-source-id", "coding-challenge")
				.header("x-cf-corr-id", UUID.randomUUID())
				.body(credentials)
				.log().all()
				
				.when().post("api/brportorch/v2/login")
				
				.then().log().all()
				.assertThat().statusCode(200)
				.spec(
						new ResponseSpecBuilder()
						.expectContentType(ContentType.JSON)
						.expectBody("loansInReview", isA(List.class))
						.expectBody("loansInReview", everyItem(hasEntry("productType","PERSONAL_LOAN")))
						.build()
				)
				
				.extract().response().as(LoanResponse.class);
		
		
	//	Assert.assertEquals(response.getLoansInReview(), "PERSONAL_LOAN");
		
	
	}

	
	//@Test(priority=2)
	public void restAssuredAuthorizationInvalidCredentials() {
		RestAssured.config();
		RestAssured.baseURI = "https://credapi.credify.tech";
		String response = given()
				.contentType(ContentType.JSON)
				.header("x-cf-source-id", "coding-challenge")
				.header("x-cf-corr-id", UUID.randomUUID())
				.body(Payload.loginCredentials("candidateInvalid999@upgrade-challenge.com","JfyoG008"))
				
				.when().post("api/brportorch/v2/login")
				
				.then().log().all()
				.assertThat().statusCode(401)
				.extract().response().asString();
	
	}
	
}
