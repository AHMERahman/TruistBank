package commons;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reporting.Loggers;

public class Commons {
	WebDriver driver;
	JavascriptExecutor js= (JavascriptExecutor) driver;
	
	public void inputValue(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Loggers.obtainLog(value + " been passed into " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element + " not found");
			Assert.fail();

		}
	}

	public void click(WebElement element) {
		try {
			element.click();
			Loggers.obtainLog(element + " :This element has been clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element + " :This element is not found");
			Assert.fail();
		}

	}
	
//	Click using JavascriptExecutor
	
	public void clickJS(WebElement element) {
		
		// Scrolling down the page till the element is found		
        
		js.executeScript("arguments[0].scrollIntoView();", element);
		
        try{
			js.executeScript("argument[0].click()", element);
			Loggers.obtainLog(element +" :This element has been clicked");
		}catch(NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element+" :This element is not found");
			Assert.fail();
			
		}
		
		
	}

	public String getText(WebElement element) { 
		String valueString = "null";
		try {
			valueString = element.getText();
			Loggers.obtainLog(element + "-------> :This element has text: " + valueString);

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element + " :The element not found");
		}
		return valueString;

	}

	public String getCurrentUrl(WebDriver driver) {
		Loggers.obtainLog("current url is: " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
}
