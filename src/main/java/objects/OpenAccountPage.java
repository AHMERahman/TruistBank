package objects;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonWaits;
import commons.Commons;

public class OpenAccountPage {

	WebDriver driver;
	Commons commons;
	CommonWaits waits;

	public OpenAccountPage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(xpath = "//a[@class='truist-globalnav-nav-link truist-globalnav-dropdown-toggle']")
	WebElement openAccount;

	@FindBy(xpath = "//a[@data-wa-linkurl='#credit-cards']")
	WebElement creditCardElement;

	@FindBy(xpath = "//*[@id=\'cta-1776368162\']/a")
	WebElement cardDetailsElements;

	@FindBy(xpath = "//h2[contains(text(),'Compare Truist Visa® credit cards')]")
	WebElement subHeadingElement1;

	@FindBy(xpath = "//*[@id=\"cta-663716574\"]/a")
	WebElement applyNowElement;

	@FindBy(xpath = "//button[@class='tru-core-button tru-core-button-primary']")
	WebElement startElement;

	private void clickOpenAccount() {
		commons.click(openAccount);
	}

	private void clickCreditCard() {
		commons.click(creditCardElement);
	}

	private void clickCardDetails() {
		commons.clickJS(cardDetailsElements);;
	}

	private void getSubHeading1(String expected) {
		assertEquals(commons.getText(subHeadingElement1), expected);
	}
	
	private void clickApplyNow() {
		commons.click(applyNowElement);
	}

	private void getCurrentUrl(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}

	private void clickStart() {
		commons.click(startElement);
	} 
 
	public void openAccountSteps(String expected, String expectedUrl) {
		clickOpenAccount();
		clickCreditCard();
		clickCardDetails();
		getSubHeading1(expected);
//		commons.scrollingJS(applyNowElement);
		clickApplyNow();
		getCurrentUrl(expectedUrl);
		clickStart();

	}
}
