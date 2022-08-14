package commons;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import reporting.Loggers;

public class Commons {
	WebDriver driver;
	CommonWaits waits;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Commons(WebDriver driver, CommonWaits waits) {
		this.driver = driver;
		this.waits = waits;
	}

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

//	click using Action class
	public void clickActionClass(WebElement element) {
		Actions actions = new Actions(driver);
		try {
			actions.sendKeys(element, Keys.RETURN).perform();
			Loggers.obtainLog(element + ":This element has been clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element + " :This element is not found");
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

//	Scroll down using JavascriptExecutor

	public void scrollingJS(WebElement element) {
		try {
			js.executeScript("arguments[0].scrollIntoView();", element);
			Loggers.obtainLog(element + " : scroll to this element");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element + " : did not scroll to this element");
			Assert.fail();
		}

	}

//	Click using JavascriptExecutor

	public void clickJS(WebElement element) {

		try {
			js.executeScript("argument[0].click()", element);
			Loggers.obtainLog(element + " :This element has been clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element + " :This element is not found");
			Assert.fail();

		}

	}

//	click using javascript esecutor (2nd method)

	public void javaScriptClick(WebElement element) {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				js.executeScript("arguments[0].click();", element);
				Loggers.obtainLog(element +"This element was clicked");
			} else {
				Loggers.obtainLog("Unable to click on element");
			}
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element + " :This element is not found");
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

	public boolean isPresent(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		if (elements.size() != 0) {
			Loggers.obtainLog(elements + "-------->This element is present and has match of" + elements.size());
			return true;
		} else {
			Loggers.obtainLog(elements + "-------->This element is NOT present and no match found" + elements.size());
			return false;
		}
	}

	public boolean elementEnabled(WebElement element) {
		if (element.isEnabled()) {
			Loggers.obtainLog(element + " :This element is enabled");
			return true;
		} else {
			Loggers.obtainLog(element + " :This element is NOT enabled");
			return false;
		}

	}

	public void selectDropDown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			Loggers.obtainLog(value + " : This value has been passed into the following element---->" + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element + " : This value not found");
			Assert.fail();

		}
	}

}
