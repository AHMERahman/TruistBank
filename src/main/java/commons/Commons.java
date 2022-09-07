package commons;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.io.Files;

import reporting.Loggers;

public class Commons {
	WebDriver driver;
	CommonWaits waits;

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
	public void clickUsingActionClass(WebElement element) {
		Actions actions = new Actions(driver);
		try {
			waits.waitUntilClickable(element);
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
			waits.waitUntilClickable(element);
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView();", element);
			Loggers.obtainLog("scroll worked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog("scroll did not work");
			Assert.fail();
		}
	}

//	Scroll down using Action class
	public void scrollUsingAction() {
		Actions action = new Actions(driver);
		try {
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Loggers.obtainLog("scroll worked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog("scroll did not work");
			Assert.fail();
		}
	}

//	Click using JavascriptExecutor

	public void clickJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			waits.waitUntilClickable(element);
			js.executeScript("arguments[0].click();", element);
			Loggers.obtainLog(element + " :This element has been clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.obtainLog(element + " :This element is not found");
			Assert.fail();

		}

	}

//	click using javascriptexecutor (2nd method)

	public void javaScriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				js.executeScript("arguments[0].click();", element);
				Loggers.obtainLog(element + "This element was clicked");
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
	
	public String getScreenshot(String testName) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String extension = format.format(date);
		File file = new File("screenShots/" + testName + "_" + extension + ".png");
		TakesScreenshot ss = (TakesScreenshot)driver;
		File outPutFile = ss.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(outPutFile, file.getAbsoluteFile());
			Loggers.obtainLog("Test has been failed \nScreenshot taken here ---> " + file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.obtainLog("Error while taking screenshot");
		}
		return file.getAbsolutePath();
	}

}
