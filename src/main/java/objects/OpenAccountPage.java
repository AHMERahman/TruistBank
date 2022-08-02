package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import commons.Commons;

public class OpenAccountPage {

	Commons commons;

	public OpenAccountPage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}

	@FindBy(xpath = "//a[@class='truist-globalnav-nav-link truist-globalnav-dropdown-toggle']")
	WebElement openAccount;

	@FindBy(xpath = "//a[@data-wa-linkurl='#credit-cards']")
	WebElement creditCardElement;
	
	@FindBy(xpath="(//a[normalize-space(text())='View card details'])[1]")
	WebElement cardDetailsElements;

	private void clickOpenAccount() {
		commons.click(openAccount);
	}

	private void clickCreditCard() {
		commons.click(creditCardElement);
		
	}

	private void clickCardDetails() {
		commons.click(cardDetailsElements);
	}
	

	public void OpenAccountSteps() {
		clickOpenAccount();
		clickCreditCard();
		clickCardDetails();

	}
}
