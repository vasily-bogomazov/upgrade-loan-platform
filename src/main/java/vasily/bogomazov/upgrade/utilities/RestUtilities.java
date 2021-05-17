package vasily.bogomazov.upgrade.utilities;

import java.util.UUID;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestUtilities {
	
	public static RequestSpecification generateRequestSpec(ReadConfig readconfig) {
		
		return new RequestSpecBuilder()
				.setBaseUri(readconfig.getParameter("api.url"))
				.setContentType(ContentType.JSON)
				.addHeader(readconfig.getParameter("api.source-header"),readconfig.getParameter("api.source-header-value"))
				.addHeader(readconfig.getParameter("api.corr-header"), UUID.randomUUID().toString())
				
				.build();
	   
	   
	}
	
}
