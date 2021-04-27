package vasily.bogomazov.upgrade.api;

public class Payload {

	
	public static String loginLoans()
	{
		
		return "{\r\n" + 
				"    \"firstName\": \"Max\",\r\n" + 
				"    \"userId\": 10002447,\r\n" + 
				"    \"userUuid\": \"09f4ed0b-1d5b-4302-bbb8-6e1078546165\",\r\n" + 
				"    \"authenticationLevel\": \"FULL\",\r\n" + 
				"    \"actorIds\": [],\r\n" + 
				"    \"loanApplications\": [\r\n" + 
				"        {\r\n" + 
				"            \"id\": 100694959,\r\n" + 
				"            \"uuid\": \"c199d063-ed6d-425c-9837-66dcbceed473\",\r\n" + 
				"            \"status\": \"OFFERED\",\r\n" + 
				"            \"productType\": \"PERSONAL_LOAN\",\r\n" + 
				"            \"sourceSystem\": \"BORROWER_FUNNEL_V2\",\r\n" + 
				"            \"purpose\": null,\r\n" + 
				"            \"createDate\": \"2021-04-26T00:57:26.127Z\",\r\n" + 
				"            \"offerAmount\": null,\r\n" + 
				"            \"initiator\": \"ACTOR\"\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"loansInReview\": [],\r\n" + 
				"    \"loanAccountSummaryAto\": []\r\n" + 
				"}";
		
		
		
}
	
	
}
