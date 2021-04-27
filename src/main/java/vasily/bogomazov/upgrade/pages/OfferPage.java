package vasily.bogomazov.upgrade.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OfferPage {

	public OfferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(youQualifyForDiscountHeader));
		String expectedofferInfoPageTitle = "Affordable Online Personal Loans | Upgrade";
		Assert.assertEquals(driver.getTitle(), expectedofferInfoPageTitle, "Personal Loan offer page title is mismatched");
		Assert.assertTrue(driver.getCurrentUrl().contains("offer-page"), "Personal Loan offer page URL is mismatched");
		
	}
	
	@FindBy (xpath="//div[@class='col-xs-12 col-sm-8 col-md-6']/h2")
	public WebElement youQualifyForDiscountHeader;
	
	@FindBy (xpath="//span[@class='sc-dmlrTW guKkvw']")
	public WebElement approvedLoanAmount;
	
	//@FindBy (xpath="//div[@class='sc-bTRMAZ kmeEIc']")
	@FindBy (xpath="//div[@class='sc-kUbhmq gIXPbp']/span") //new locator, changed on 04/26/2021
	public WebElement monthlyPayment;
	
	//@FindBy (xpath="//li[@data-auto='defaultLoanTerm']/div[@class='sc-bTRMAZ eILGho']")
	@FindBy (xpath="//div[@data-auto='defaultLoanTerm']") //new locator, changed on 04/26/2021
	public WebElement term;
	
	//@FindBy (xpath="//li[@data-auto='defaultLoanInterestRate']/div[@class='sc-bTRMAZ eILGho']")
	@FindBy (xpath="//div[@data-auto='defaultLoanInterestRate']") //new locator, changed on 04/26/2021
	public WebElement interestRate;
	
	//@FindBy (xpath="//div[@data-auto='defaultAPR']")
	@FindBy (xpath="//div[@data-auto='defaultMoreInfoAPR']/div") //new locator, changed on 04/26/2021
	public WebElement apr;

	@FindBy (className="header-nav")
	public WebElement navMenu;
	
	@FindBy (linkText="Sign Out")
	public WebElement signOutButton;
	
	@FindBy (xpath="//h1[@class='title--secondary text--weight-light text--color-primary']")
	public WebElement logoutPageHeader;
	
}
