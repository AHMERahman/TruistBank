package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.Commons;

public class OpenCheckingSavingAccPage {
	WebDriver driver;
	Commons commons;
	
	public OpenCheckingSavingAccPage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.commons=commons; 
	}
	
	@FindBy(xpath="//span[contains(text(),'Checking & savings')]")
	WebElement checkingSavingElement;
	
	private void clickCheckingSaving() {
		commons.click(checkingSavingElement);
	}
	
	public void openCheckingSavingSteps() {
		clickCheckingSaving();
	}
	

}
