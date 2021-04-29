package vasily.bogomazov.upgrade.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import vasily.bogomazov.upgrade.DTO.CredentialsBody;
import vasily.bogomazov.upgrade.DTO.LoanResponse;
import vasily.bogomazov.upgrade.DTO.LoansInReviewDTO;
import vasily.bogomazov.upgrade.utilities.ReadConfig;

import static vasily.bogomazov.upgrade.utilities.RestUtilities.generateRequestSpec;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class Authorization {
	public static ReadConfig readconfig = new ReadConfig("./Configuration/API.properties"); 
	
	
	@Test (priority=1)
	public void restAssuredAuthorizationValidCredentials()  {
		
		CredentialsBody credentials = new CredentialsBody();
		credentials.setUsername(readconfig.getParameter("api.username"));
		credentials.setPassword(readconfig.getParameter("api.password"));
		credentials.setRecaptchaToken(readconfig.getParameter("api.recaptcha"));
		LoanResponse response = given()
				.spec(generateRequestSpec(readconfig))
				.body(credentials)
				.log().all()
				
				.when().post(readconfig.getParameter("api.uri.login"))
				
				.then().log().all()
				.assertThat().statusCode(200)
		// 1st solution
				.spec(
						new ResponseSpecBuilder()
						.expectContentType(ContentType.JSON)
						.expectBody("loansInReview", isA(List.class))
						.expectBody("loansInReview", everyItem(hasEntry("productType","PERSONAL_LOAN")))
						.build()
				)
				.extract().response().as(LoanResponse.class);
		//2nd solution
		for (LoansInReviewDTO loan : response.getLoansInReview()) {
			Assert.assertEquals(loan.getProductType(), "PERSONAL_LOAN", "productType is not matching");
		}	
		
	}

	
	@Test(priority=2)
	public void restAssuredAuthorizationInvalidCredentials() {
		
		CredentialsBody credentials = new CredentialsBody();
		credentials.setUsername(readconfig.getParameter("api.invalid-username"));
		credentials.setPassword(readconfig.getParameter("api.password"));
		credentials.setRecaptchaToken(readconfig.getParameter("api.recaptcha"));
		String response = given()
				.spec(generateRequestSpec(readconfig))
				.body(credentials)
				
				.when().post(readconfig.getParameter("api.uri.login"))
				
				.then().log().all()
				.assertThat().statusCode(401)
				.extract().response().asString();
	}
	
}
