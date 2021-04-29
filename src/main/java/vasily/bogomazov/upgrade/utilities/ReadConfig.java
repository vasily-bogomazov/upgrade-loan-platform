package vasily.bogomazov.upgrade.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig(String path ) {

		File src = new File(path);

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
		
	
	public String getParameter(String param) {
		return prop.getProperty(param);
	}	

}