package vasily.bogomazov.upgrade.api;

public class Payload {

	public static String loginCredentials(String username, String password) {
		
		
		String payload = "{\r\n" + 
				"    \"username\": \""+username+"\",\r\n" + 
				"    \"password\": \""+password+"\",\r\n" + 
				"     \"recaptchaToken\": \"coding-challenge\"\r\n" + 
				"}";
		return payload;
	
	}
	
	
	
	
	public static String loginLoans()
	{
		
		String payload= "{\r\n" + 
				"    \"firstName\": \"Ian\",\r\n" + 
				"    \"userId\": 9114917,\r\n" + 
				"    \"userUuid\": \"34c16f53-38c4-461a-bd14-11fa748d2663\",\r\n" + 
				"    \"authenticationLevel\": \"FULL\",\r\n" + 
				"    \"actorIds\": [\r\n" + 
				"        9096778\r\n" + 
				"    ],\r\n" + 
				"    \"loanApplications\": [\r\n" + 
				"        {\r\n" + 
				"            \"id\": 100154933,\r\n" + 
				"            \"uuid\": \"19458dac-dcbb-4e40-bc92-d6939071912d\",\r\n" + 
				"            \"status\": \"EXPIRED\",\r\n" + 
				"            \"productType\": \"DEPOSIT\",\r\n" + 
				"            \"sourceSystem\": \"BORROWER_FUNNEL_V2\",\r\n" + 
				"            \"purpose\": null,\r\n" + 
				"            \"createDate\": \"2021-01-18T23:39:09.027Z\",\r\n" + 
				"            \"offerAmount\": null,\r\n" + 
				"            \"initiator\": \"ACTOR\"\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"loansInReview\": [\r\n" + 
				"        {\r\n" + 
				"            \"id\": 9545966,\r\n" + 
				"            \"uuid\": \"230ea84a-7199-41c9-bf38-fff27e35970d\",\r\n" + 
				"            \"status\": \"WITHDRAWN\",\r\n" + 
				"            \"productType\": \"PERSONAL_LOAN\",\r\n" + 
				"            \"collateralDistributionType\": null,\r\n" + 
				"            \"hasOpenBackendCounter\": false,\r\n" + 
				"            \"purpose\": \"CREDIT_CARD\",\r\n" + 
				"            \"createDate\": \"2019-08-21T18:18:59.959Z\",\r\n" + 
				"            \"postIssuanceStatus\": null,\r\n" + 
				"            \"addon\": null\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"loanAccountSummaryAto\": [\r\n" + 
				"        {\r\n" + 
				"            \"loanAccountNumber\": null,\r\n" + 
				"            \"postIssuanceLoanStatus\": null,\r\n" + 
				"            \"daysPastDue\": 0,\r\n" + 
				"            \"loanProductType\": null\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
		
		return payload;
		
}
	
	
}
