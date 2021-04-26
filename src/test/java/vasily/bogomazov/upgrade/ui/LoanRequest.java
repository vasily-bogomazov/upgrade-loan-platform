package vasily.bogomazov.upgrade.ui;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import vasily.bogomazov.upgrade.DTO.LoanOfferDTO;
import vasily.bogomazov.upgrade.pages.FunnelPage;
import vasily.bogomazov.upgrade.pages.OfferPage;
import vasily.bogomazov.upgrade.pages.PersonalInfoPage;
import vasily.bogomazov.upgrade.utilities.BaseClass;

public class LoanRequest extends BaseClass{

	FunnelPage funnelPage;
	OfferPage offerPage;
	WebDriverWait wait;
	PersonalInfoPage personal;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		init(readconfig.getParameter("browser"));
		logger = Logger.getLogger(LoanRequest.class);
		funnelPage = new FunnelPage(driver);
		wait = new WebDriverWait(driver, 20);
	}
 
	@Test
	public void verifyLoanCanBeRequested() throws InterruptedException {
	
		wait.until(ExpectedConditions.visibilityOf(funnelPage.GetStartedHereTitle));
		SoftAssert assertLoansCards = new SoftAssert();
		String loansCardsPageTitle = driver.getTitle();
		String expectedLoansCardsPageTitle = "Upgrade - Personal Loans and Cards";
		assertLoansCards.assertEquals(loansCardsPageTitle,expectedLoansCardsPageTitle , "User is not landed on a Personal Loans and Cards Page");
		logger.info("User Lands on a Personal Loans and Cards page");
		funnelPage.LoanAmountInputBox.sendKeys(readconfig.getParameter("amount"));
		logger.info("Loan Amount entered is: " + readconfig.getParameter("amount")); 
		Select lnPurSelect = new Select (funnelPage.LoanPurposeDropbox);
		String loanPurposeOption = "Pay off Credit Cards";
		lnPurSelect.selectByVisibleText(loanPurposeOption);
		logger.info("Loan Purpose selected is: "+ loanPurposeOption);
		funnelPage.CheckYourRateBtn.click();
		assertLoansCards.assertAll();
		
		personal = new PersonalInfoPage(driver);
		wait.until(ExpectedConditions.visibilityOf(personal.basicInfoPageTitle));
		SoftAssert assertBasicInfo = new SoftAssert();
		String basicInfoPageTitle = driver.getTitle();
		String expectedbasicInfoPageTitle = "Check your rate for a personal loan | Upgrade";
		assertBasicInfo.assertEquals(basicInfoPageTitle, expectedbasicInfoPageTitle, "Clicking on Check Your Rate button does not land User on a Basic information page ");
		logger.info("User is on a Basic information page after clicking Check Your Rate button"); 
					
		personal.borrowerFirstName.sendKeys(readconfig.getParameter("firstName"));
		personal.borrowerLastName.sendKeys(readconfig.getParameter("lastName"));
		logger.info("Entered First and Last Name values: " + readconfig.getParameter("firstName") + " " + readconfig.getParameter("lastName"));
			
		String address=readconfig.getParameter("address");
		personal.borrowerStreet.sendKeys(address);
		personal.borrowerStreetOptions.get(0).click();
		logger.info("Entered Address: " + address);
		String dob = readconfig.getParameter("dob");
		personal.borrowerDateOfBirth.sendKeys(dob);
		logger.info("Entered Date of Birth: " + dob.substring(0,2)+ "/" + dob.substring(2,4)+ "/" + dob.substring(4,8)); 
		personal.continueButton.click();
			
		wait.until(ExpectedConditions.visibilityOf(personal.borrowerIncome));
		Assert.assertTrue(driver.getCurrentUrl().contains("income"), "Clicking on Continue button does not land User on an Income information Page");
		logger.info("User is on an Income information page after clicking Continue buton");
		personal.borrowerIncome.sendKeys(readconfig.getParameter("income"));
		personal.borrowerAdditionalIncome.sendKeys(readconfig.getParameter("addIncome"));
		logger.info("Entered Individual Annual Income: " + readconfig.getParameter("income"));
		logger.info("Entered Additional Annual Income: " + readconfig.getParameter("addIncome"));
			
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();", personal.continueButton);
		
		assertBasicInfo.assertAll();
		
		wait.until(ExpectedConditions.visibilityOf(personal.emailAddressInput));
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Clicking on Continue button does not land User on a Create an Account Page");
		logger.info("User is on a Create an Account Page after clicking on Continue button");
						
		String email ="candidate" +getRandomNumber(3) + "@upgrade-challenge.com";
		String password= getRandomString(5)+getRandomNumber(3);
		personal.emailAddressInput.sendKeys(email);
			
		boolean checkMark = false;
		while (!checkMark) {
			personal.passwordInput.sendKeys(password);
			if (!driver.findElements(By.xpath("//span[@class='sc-idOhPF jffbOf icon-checkmark-thick']")).isEmpty()) {
				checkMark=true;
			} else {
				logger.info("Password " + password+ " is not meeting the requirements. Check mark is not visible. New password will be generated");
				password = getRandomString(1).toUpperCase()+getRandomString(5).toLowerCase()+getRandomNumber(3);
				personal.passwordInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
			}		
		}
			
		logger.info("Entered User's email: " + email); 
		logger.info("Entered User's password: " + password);
			
		personal.agreementCheckBox.click();
		js.executeScript("arguments[0].click();", funnelPage.CheckYourRateBtn);
			
		offerPage = new OfferPage(driver);
		wait.until(ExpectedConditions.visibilityOf(offerPage.youQualifyForDiscountHeader));
		SoftAssert assertOfferInfo = new SoftAssert();
		String offerInfoPageTitle = driver.getTitle();
		String expectedofferInfoPageTitle = "Affordable Online Personal Loans | Upgrade";
		assertOfferInfo.assertEquals(offerInfoPageTitle, expectedofferInfoPageTitle, "Clicking on Check Your Rate button doesnot land User on a Offer information Page");
		logger.info("User is on a Offer information page after clicking on Check Your Rate button"); 
		
		assertOfferInfo.assertAll();
		
		LoanOfferDTO expectedLoanOffer = new LoanOfferDTO();
		expectedLoanOffer.setApprovedLoanAmount(offerPage.approvedLoanAmount.getText());
		expectedLoanOffer.setMonthlyPayment(offerPage.monthlyPayment.getText());
		expectedLoanOffer.setTerm(offerPage.term.getText());
		expectedLoanOffer.setInterestRate(offerPage.interestRate.getText());
		expectedLoanOffer.setApr(offerPage.apr.getText());
			
		logger.info(expectedLoanOffer);
			
		wait.until(ExpectedConditions.visibilityOf(offerPage.navMenu));
		offerPage.navMenu.click();
		wait.until(ExpectedConditions.visibilityOf(offerPage.signOutButton));
		offerPage.signOutButton.click();
			
		wait.until(ExpectedConditions.visibilityOf(offerPage.logoutPageHeader));
		Assert.assertTrue(driver.getCurrentUrl().contains("logout"),  "User is not logged out after clicking Sign Out");
		logger.info("User is successfully logged out after clicking Sign Out"); 
						
		driver.get(readconfig.getParameter("loginURL"));
		wait.until(ExpectedConditions.visibilityOf(personal.signInButton));
					
		personal.emailAddressInput.sendKeys(email);
		personal.passwordInput.sendKeys(password);
		personal.signInButton.click();
		wait.until(ExpectedConditions.visibilityOf(offerPage.youQualifyForDiscountHeader));
		Assert.assertTrue(driver.getCurrentUrl().contains("offer-page"),  "Signing In with User Email and Password doesnot land User on an Offer Page");
		logger.info("Signing In with User Email " + email + " and Password " + password+ " lands User on an Offer Page"); 
			
		SoftAssert assertLoanOffer = new SoftAssert();		
		assertLoanOffer.assertEquals (expectedLoanOffer.getApprovedLoanAmount(), offerPage.approvedLoanAmount.getText(), "Loan Amount values from Loan Request and Loan Offer do not match");
		assertLoanOffer.assertEquals (expectedLoanOffer.getMonthlyPayment(), offerPage.monthlyPayment.getText(), "Monthly Payment values from Loan Request and Loan Offer do not");
		assertLoanOffer.assertEquals(expectedLoanOffer.getTerm(), offerPage.term.getText(), "Term values from Loan Request and Loan Offer do not match");	
		assertLoanOffer.assertEquals(expectedLoanOffer.getInterestRate(), offerPage.interestRate.getText(), "Interest Rate values from Loan Request and Loan Offer do not match");
		assertLoanOffer.assertEquals(expectedLoanOffer.getApr(), offerPage.apr.getText(), "APR values from Loan Request and Loan Offer do not match");
		
		assertLoanOffer.assertAll();
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenShot(driver, result.getName());
			logger.info("Test is Failed");
		} else {
			logger.info("Test is Passed");
			
		}
		driver.quit();;
	}
}
