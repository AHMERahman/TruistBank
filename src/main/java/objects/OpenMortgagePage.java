package objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.Commons;

public class OpenMortgagePage {
	
	WebDriver driver;
	Commons commons;
	
	public OpenMortgagePage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.commons=commons;
	}
	
	@FindBy(xpath="(//span[contains(text(),'Mortgage')])[1]")
	WebElement mortgageElement;
	
	@FindBy(xpath="//span[@class='truist-globalnav-header-linktext' and contains(text(), 'Mortgage')]")
	WebElement mortgageElementAgain;
	
	@FindBy(xpath="(//a[contains(text(),'Buy a home')])[1]")
//	@FindBy(xpath="(//a[@href='/mortgage/buy-home'])[2]")
	WebElement BuyHomeElement;
	
//	By ifElementPresent = By.xpath("(//a[@href='/mortgage/buy-home'])[2]");
	
	@FindBy(xpath="//a[@href='#calculator']")
	WebElement AffordabilityCalculatorElement;
	
	@FindBy(xpath="//h2[contains(text(),'How much can you afford?')]")
	WebElement getTitleElement1;
	
	private void clickMortgage() {
		commons.click(mortgageElement);
	}
	
	private void clickMortgageAgain() {
		commons.click(mortgageElementAgain); 
	}
	
	private void clickBuyHome() {
		commons.click(BuyHomeElement);;
	}
	
//	private void buyHomeElementPresent() {
//		commons.isPresent(ifElementPresent);
//	}
	

	private void clickAffordabilityCalculator() {
		commons.click(AffordabilityCalculatorElement);
	}
	
//	private void getSubheading1(String expectedTitle1) {
//		assertEquals(commons.getText(getTitleElement1), expectedTitle1);
//		
//	}
	
	
	public void openMortgageSteps() {
		clickMortgage();
		clickMortgageAgain();
		clickBuyHome(); 
		
//	buyHomeElementPresent();
		
		
//		clickAffordabilityCalculator();
//		getSubheading1(expectedTitle1);
	}

}
