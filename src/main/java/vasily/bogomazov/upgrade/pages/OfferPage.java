package vasily.bogomazov.upgrade.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class OfferPage {
		
	public OfferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		SoftAssert softAssert = new SoftAssert();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(youQualifyForDiscountHeader));
		String expectedofferInfoPageTitle = "Affordable Online Personal Loans | Upgrade";
		softAssert.assertEquals(driver.getTitle(), expectedofferInfoPageTitle, "Personal Loan offer page title is mismatched");
		softAssert.assertTrue(driver.getCurrentUrl().contains("offer-page"), "Personal Loan offer page URL is mismatched");
		
	}
	
	@FindBy (xpath="//div[@class='col-xs-12 col-sm-8 col-md-6']/h2")
	public WebElement youQualifyForDiscountHeader;
	
	@FindBy (xpath="//span[@data-auto='userLoanAmount']")
	public WebElement approvedLoanAmount;
	
	@FindBy (css="[data-auto='defaultMonthlyPayment']")
	public WebElement monthlyPayment;
	
	@FindBy (xpath="//div[@data-auto='defaultLoanTerm']")
	public WebElement term;
	
	@FindBy (xpath="//div[@data-auto='defaultLoanInterestRate']")
	public WebElement interestRate;
	
	@FindBy (xpath="//div[@data-auto='defaultMoreInfoAPR']/div")
	public WebElement apr;

	@FindBy (className="header-nav")
	public WebElement navMenu;
	
	@FindBy (linkText="Sign Out")
	public WebElement signOutButton;
	
	@FindBy (xpath="//h1[@class='title--secondary text--weight-light text--color-primary']")
	public WebElement logoutPageHeader;
	
}
