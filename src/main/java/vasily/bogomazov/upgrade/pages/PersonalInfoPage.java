package vasily.bogomazov.upgrade.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {
	
	public WebDriver ldriver;

	public PersonalInfoPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@class='col-xs-12 col-sm-8 col-md-6']/h1")
	public WebElement basicInfoPageTitle;
	
	@FindBy(name = "borrowerFirstName")
	public WebElement borrowerFirstName;
	
	@FindBy(name = "borrowerLastName")
	public WebElement borrowerLastName;
	
	@FindBy(name = "borrowerStreet")
	public WebElement borrowerStreet;
	
	@FindBy(xpath="//li[@role='option']")
	public List <WebElement> borrowerStreetOptions;
	
	@FindBy(name = "borrowerDateOfBirth")
	public WebElement borrowerDateOfBirth;
	
	@FindBy(name = "borrowerIncome")
	public WebElement borrowerIncome;
	
	@FindBy(name = "borrowerAdditionalIncome")
	public WebElement borrowerAdditionalIncome;
	
	@FindBy(name = "username")
	public WebElement emailAddressInput;
	
	@FindBy(name = "password")
	public WebElement passwordInput;
	
	@FindBy(xpath="//input[@name='agreements']/following-sibling::div[1]")
	public WebElement agreementCheckBox;
	
	@FindBy (xpath="//div[@class='section']/button")
	public WebElement continueButton;
	
	@FindBy (xpath="//button[@class='sc-citwmv dhZgvl']")
	public WebElement signInButton;		
	
}
