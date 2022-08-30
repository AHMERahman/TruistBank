package objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonWaits;
import commons.Commons;

public class OpenCreditCardPage {
	WebDriver driver;
	Commons commons;
	CommonWaits waits;

	public OpenCreditCardPage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}
	
	@FindBy(xpath="(//button[@class='tru-core-button tru-core-button-secondary'])[2]")
	WebElement noElement;
	
	@FindBy(xpath="//input[@id='tru-core-input-1']")
	WebElement zipCodeElement;
	
	@FindBy(xpath="//button[@class='tru-core-button tru-core-button-primary']")
	WebElement continueButtonElement;
	
	private void getCurrentUrl(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}
	
	private void clickNo() {
		commons.click(noElement);
	}
	
	private void inputZipcode(String value) {
		commons.inputValue(zipCodeElement, value);
	}
	
	private void clickContinueButton() {
		commons.click(continueButtonElement);
	}
	
	
	
	public void openCreditCardSteps(String expectedUrl, String value) {
		getCurrentUrl(expectedUrl);
		clickNo();
		inputZipcode(value);
		clickContinueButton();
		
	}
	
}
