package vasily.bogomazov.upgrade.api;

import io.restassured.path.json.JsonPath;

public class BaseMethodsAPI {
	
	public static JsonPath rawToJson (String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}

}
