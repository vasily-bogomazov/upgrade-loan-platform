package vasily.bogomazov.upgrade.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferPage {

	public WebDriver ldriver;

	public OfferPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath="//div[@class='col-xs-12 col-sm-8 col-md-6']/h2")
	public WebElement youQualifyForDiscountHeader;
	
	@FindBy (xpath="//span[@class='sc-dmlrTW guKkvw']")
	public WebElement approvedLoanAmount;
	
	@FindBy (xpath="//div[@class='sc-bTRMAZ kmeEIc']")
	public WebElement monthlyPayment;
	
	@FindBy (xpath="//li[@data-auto='defaultLoanTerm']/div[@class='sc-bTRMAZ eILGho']")
	public WebElement term;
	
	@FindBy (xpath="//li[@data-auto='defaultLoanInterestRate']/div[@class='sc-bTRMAZ eILGho']")
	public WebElement interestRate;
	
	@FindBy (xpath="//div[@data-auto='defaultAPR']")
	public WebElement apr;

	@FindBy (className="header-nav")
	public WebElement navMenu;
	
	@FindBy (linkText="Sign Out")
	public WebElement signOutButton;
	
	@FindBy (xpath="//h1[@class='title--secondary text--weight-light text--color-primary']")
	public WebElement logoutPageHeader;
	
}
