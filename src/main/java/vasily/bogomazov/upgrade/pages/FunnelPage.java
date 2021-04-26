package vasily.bogomazov.upgrade.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FunnelPage {
	
	public WebDriver ldriver;

	public FunnelPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@class='sc-jUEnpm flwtkv title--large']")
	public WebElement GetStartedHereTitle;
	
	@FindBy(name = "desiredAmount")
	public WebElement LoanAmountInputBox;
	
	@FindBy (xpath="//*[@class='sc-khAkjo kniQaM sc-nFpLZ gijkwK']")
	public WebElement LoanPurposeDropbox;
	
	@FindBy (xpath="//button[@type='submit' or @class='sc-jcVebW eYlwys section']")
	public WebElement CheckYourRateBtn;
	
}
