package objects;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.Commons;

public class GoToPersonalInfoFormPage {

	WebDriver driver;
	Commons commons;

	public GoToPersonalInfoFormPage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(xpath = "(//button[@class='tru-core-button tru-core-button-secondary'])[2]")
	WebElement noElement;

	@FindBy(xpath = "//*[@id=\"tru-core-radio-button-label-2\"]/tru-core-form-field-label")
	WebElement getSubheadingElement;

	@FindBy(xpath = "//*[@id=\"tru-core-input-1\"]")
	WebElement zipCodeElement;

	@FindBy(xpath = "//button[@class=\"tru-core-button tru-core-button-primary\"]")
	WebElement continueElement;

	@FindBy(xpath = "//h1")
	WebElement subheadingElement2;

	private void clickNo() {
		commons.click(noElement);
	}

	private void getSubheading(String expectedSubheading) {
		assertEquals(commons.getText(getSubheadingElement), expectedSubheading);
	}

	private void inputZipcode(String value) {
		commons.inputValue(zipCodeElement, value);
	}

	private void clickContinue() {
		commons.click(continueElement);
	}

	private void getSubheading2(String expected2) {
		assertEquals(commons.getText(subheadingElement2), expected2);
	}

	public void goToPersonalInfoFormPageSteps(String expectedSubheading, String value, String expected2) {
		clickNo();
		getSubheading(expectedSubheading);
		inputZipcode(value);
		clickContinue();
		getSubheading2(expected2);
	}

}
