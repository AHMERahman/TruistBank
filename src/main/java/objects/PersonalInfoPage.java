package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.Commons;
import utils.PersonalInfoData;

public class PersonalInfoPage {

	WebDriver driver;
	Commons commons;

	public PersonalInfoPage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(xpath = "//input[@id='tru-core-input-4']")
	WebElement firstNameElement;

	@FindBy(xpath = "//input[@id='tru-core-input-6']")
	WebElement lastNameElement;

	@FindBy(xpath = "//button[@id='tru-core-select-trigger-3']")
	WebElement selectCitizenshipElement;

	@FindBy(xpath = "//li[@id='select-1-option-id-2']")
	WebElement permResidentElement;

	@FindBy(xpath = "//button[@id='tru-core-select-trigger-13']")
	WebElement selectAdditionalCitizenshipElement;

	@FindBy(xpath = "//li[@id='select-10-option-id-19']")
	WebElement bangladeshElement;

	@FindBy(xpath = "//input[@id='tru-core-input-2']")
	WebElement inputDOBElement;

	@FindBy(xpath = "//input[@id='tru-core-input-22']")
	WebElement ssnElement;

	@FindBy(xpath = "//input[@id='tru-core-input-3']")
	WebElement inputMobileNumElement;

	@FindBy(xpath = "//*[@id=\'tru-core-checkbox-label-1\']/tru-core-form-field-label")
	WebElement checkBoxElement;

	private void inputFirstName(String firstName) {
		commons.inputValue(firstNameElement, firstName);
	}

	private void inputLastName(String lastName) {
		commons.inputValue(lastNameElement, lastName);
	}

	private void clickSelectCitizenship() {
		commons.click(selectCitizenshipElement);
	}

	private void clickPermanentResident() {
		commons.click(permResidentElement);
	}

	private void clickAdditionalCitizenship() {
		commons.click(selectAdditionalCitizenshipElement);
	}

	private void clickBangladesh() {
		commons.click(bangladeshElement);
	}

	private void inputDOB(String dob) {
		commons.inputValue(inputDOBElement, dob);
	}

	private void inputSSN(String ssn) {
		commons.inputValue(ssnElement, ssn);
	}

	private void inputMobile(String mobileNum) {
		commons.inputValue(inputMobileNumElement, mobileNum);
	}

	private void clickCheckBox() {
		commons.click(checkBoxElement);
	}

	public void personalInfoPageSteps(String firstName, String lastName, String dob, String ssn, String mobileNum) {
		inputFirstName(firstName);
		inputLastName(lastName);
		clickSelectCitizenship();
		clickPermanentResident();
		clickAdditionalCitizenship();
		clickBangladesh();
		inputDOB(dob);
		inputSSN(ssn);
		inputMobile(mobileNum);
		clickCheckBox();

	}
	
	public void personalInfoPageSteps(PersonalInfoData personalInfoData) {
		inputFirstName(personalInfoData.getFirstName());
		inputLastName(personalInfoData.getLastName());
		clickSelectCitizenship();
		clickPermanentResident();
		clickAdditionalCitizenship();
		clickBangladesh();
		inputDOB(personalInfoData.getDob());
		inputSSN(personalInfoData.getSsn());
		inputMobile(personalInfoData.getMobileNum());
		clickCheckBox();

	}

}
