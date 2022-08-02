package objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.Commons;

public class OpenAccountPage {

	WebDriver driver;
	Commons commons;

	public OpenAccountPage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.commons = commons;
	}

	@FindBy(xpath = "//a[@class='truist-globalnav-nav-link truist-globalnav-dropdown-toggle']")
	WebElement openAccount;

	@FindBy(xpath = "//a[@data-wa-linkurl='#credit-cards']")
	WebElement creditCardElement;
	
	@FindBy(xpath="(//a[normalize-space(text())='View card details'])[1]")
	WebElement cardDetailsElements;
	
	@FindBy(xpath="//h2[contains(text(),'Compare')]")
	WebElement titleElement;

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

	public void OpenAccountSteps(String expected, String currentUrl) {
		clickOpenAccount();
		clickCreditCard();
		clickCardDetails();
		getTitle(expected);
		getCurrentUrl(currentUrl);
		

	}
}
