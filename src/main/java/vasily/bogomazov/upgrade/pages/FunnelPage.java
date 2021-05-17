package vasily.bogomazov.upgrade.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FunnelPage {
	
	public FunnelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(getStartedHereTitle,loanAmountInputBox, loanPurposeDropbox, checkYourRateBtn));
		String expectedLoansCardsPageTitle = "Upgrade - Personal Loans and Cards";
		Assert.assertEquals(driver.getTitle(), expectedLoansCardsPageTitle, "Loans and Cards page title is mismatched");
	}

	@FindBy(xpath = "//*[@class='sc-jUEnpm flwtkv title--large']")
	public WebElement getStartedHereTitle;
	
	@FindBy(name = "desiredAmount")
	public WebElement loanAmountInputBox;
	
	@FindBy (css="select[data-auto='dropLoanPurpose']")
	public WebElement loanPurposeDropbox;
	
	@FindBy (xpath="//button[@type='submit' or @class='sc-jcVebW eYlwys section']")
	public WebElement checkYourRateBtn;
	
}
