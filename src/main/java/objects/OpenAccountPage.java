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

	@FindBy(xpath = "(//a[normalize-space(text())='View card details'])[1]")
	WebElement cardDetailsElements;

	@FindBy(xpath = "//h2[contains(text(),'Compare')]")
	WebElement titleElement;

	@FindBy(xpath = "//h2[contains(text(), 'OPTION 1')]")
	WebElement subHeadingElement;

	@FindBy(xpath = "(//a[@data-wa-linkname='Apply now'])[1]")
	WebElement applyNow;

	@FindBy(xpath = "(//h2)[2]")
	WebElement titleElement2;

	@FindBy(xpath = "//button[contains(@class, 'tru-core-button tru-core-button-primary')]")
	WebElement startButtonElement;

	@FindBy(xpath = "//h1[contains(text(),'get started.')]")
	WebElement subHeadingElement3;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement clickNoElement;
	
	@FindBy(xpath="//input[@aria-required='true']")
	WebElement inPutZipElement;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement clickContinueButton;

	private void clickOpenAccount() {
		commons.click(openAccount);
	}

	private void clickCreditCard() {
		commons.click(creditCardElement);

	}

	private void clickCardDetails() {
		commons.click(cardDetailsElements);
	}

	private void getTitle(String expected) {
		assertEquals(commons.getText(titleElement), expected);
	}

	private void getCurrentUrl(String currentUrl) {
		assertEquals(commons.getCurrentUrl(driver), currentUrl);
	}

	private void scrollToElement() {
		commons.scrollingJS(applyNow);
	}

	private void getSubHeading(String expectedSubheading) {
		assertEquals(commons.getText(subHeadingElement), expectedSubheading);
	}

	private void clickApply() {
		commons.click(applyNow);
	}

	private void getTitle2(String expected2) {
		assertEquals(commons.getText(titleElement2), expected2);
	}

	private void isButtonEnabled() {
		commons.elementEnabled(startButtonElement);
	} 

	private void clickStartButton() {
		commons.click(startButtonElement);
	}

	private void getSubHeading3(String expected3) {
		assertEquals(commons.getText(subHeadingElement3), expected3);
	}
	
	private void clickNOButton() {
		commons.click(clickNoElement);
	}
	
	private void inputZipValue(String value) {
		commons.inputValue(inPutZipElement, value);
	}
	
	private void clickSubmitButton() {
		commons.click(clickContinueButton);
	}

	public void openAccountSteps(String expected, String currentUrl, String expectedSubheading, String currentUrl2,
			String expected2, String expected3, String value) {
		clickOpenAccount();
		clickCreditCard();
		clickCardDetails();
		getTitle(expected);
		getCurrentUrl(currentUrl);
//		scrollToElement();
		getSubHeading(expectedSubheading);
		clickApply();
		getCurrentUrl(currentUrl2);
		getTitle2(expected2);
		isButtonEnabled();
		clickStartButton();
		getSubHeading3(expected3);
		clickNOButton();
		inputZipValue(value);
		clickSubmitButton();
	}
}
