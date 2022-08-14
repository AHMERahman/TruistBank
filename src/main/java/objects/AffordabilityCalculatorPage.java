package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.Commons;

public class AffordabilityCalculatorPage {

	WebDriver driver;
	Commons commons;

	public AffordabilityCalculatorPage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}
	
	@FindBy(xpath="//select[contains(@id, 'AffordabilityCalculationOption')]")
	WebElement selectIncomeElement;
	
	
	
	private void selectIncomeElement() {
		commons.click(selectIncomeElement);
		commons.selectDropDown(selectIncomeElement, "0");
	}
	
	public void affordabilityCalculatorSteps() {
		selectIncomeElement();
	}
 
}
