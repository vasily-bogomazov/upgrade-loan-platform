package vasily.bogomazov.upgrade.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver= null;
	public static ReadConfig readconfig = new ReadConfig("./Configuration/config.properties"); 
	public String baseURL = readconfig.getParameter("URL"); 
	public static Logger logger;
	

	public void init() throws IOException {


		PropertyConfigurator.configure("log4j.properties");
		try {
				if (driver == null)

				{
					String browserName = readconfig.getParameter("browser");

					if (browserName.equals("chrome")) {
						WebDriverManager.chromedriver().cachePath(System.getProperty("user.dir") + "//Drivers//").setup();
						driver = new ChromeDriver();
						DesiredCapabilities capabilities = DesiredCapabilities.chrome();
						capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
					} else if (browserName.equals("firefox")) {
						FirefoxOptions options = new FirefoxOptions();
						WebDriverManager.firefoxdriver().cachePath(System.getProperty("user.dir") + "//Drivers//").setup();
						options.setCapability("marionette", true);
						driver = new FirefoxDriver(options);

					} else if (browserName.equals("ie")) {
						DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
						capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
						capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
						WebDriverManager.iedriver().cachePath(System.getProperty("user.dir") + "//Drivers//").setup();
						driver = new InternetExplorerDriver();
						driver.manage().deleteAllCookies();
					}
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
					try {
						driver.get(baseURL);
					} catch (TimeoutException e) {
		
						driver.close();
					}

				}
 		}

		catch (Exception e) {
			
			System.out.println(e);
		}
	}


	public void takeScreenShot(WebDriver driver, String scrname) {
		File directory = new File("screenshotFolder");
		directory.mkdir();

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_");

		System.out.println(fileName);
		System.out.println(System.getProperty("user.dir"));
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,
					new File(System.getProperty("user.dir") + "//screenshotFolder//" + fileName + scrname + ".png"));
			System.out.println("Screenshot taken!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getRandomNumber(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "0123456789";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

}
