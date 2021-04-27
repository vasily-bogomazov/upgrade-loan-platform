package vasily.bogomazov.upgrade.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Authorization {
	
	
	@Test (priority=1)
	public void restAssuredAuthorizationValidCredentials() {
		RestAssured.config();
		RestAssured.baseURI = "https://credapi.credify.tech";
		
		
		String response = given().header("Content-Type", "application/json").header("x-cf-source-id", "coding-challenge").header("x-cf-corr-id", "08692950-a631-11eb-adb3-2f90155418e6")
		.body("{\r\n" + 
				"    \"username\": \"candidate797@upgrade-challenge.com\",\r\n" + 
				"    \"password\": \"UlOZG557\",\r\n" + 
				"     \"recaptchaToken\": \"coding-challenge\"\r\n" + 
				"}").when().post("api/brportorch/v2/login").then().log().all().assertThat().statusCode(200).body("firstName", equalTo("Max")).extract().response().asString();
		
		
		JsonPath js = BaseMethodsAPI.rawToJson(response);
		
		String productType = js.get("loanApplications[0].productType");
		Assert.assertEquals(productType, "PERSONAL_LOAN");
		
	
	}

	
	//@Test(priority=2)
	public void restAssuredAuthorizationInvalidCredentials() {
		RestAssured.config();
		RestAssured.baseURI = "https://credapi.credify.tech";
		given().header("Content-Type", "application/json").header("x-cf-source-id", "coding-challenge").header("x-cf-corr-id", "08692950-a631-11eb-adb3-2f90155418e6")
		.body("{\r\n" + 
				"    \"username\": \"candidate701@upgrade-challenge.com\",\r\n" + 
				"    \"password\": \"Invalid\",\r\n" + 
				"     \"recaptchaToken\": \"coding-challenge\"\r\n" + 
				"}").when().post("api/brportorch/v2/login").then().log().all().assertThat().statusCode(401);
	
	}
	
}
