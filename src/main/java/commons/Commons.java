package commons;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Commons {
	
	public void inPutValue(WebElement element, String value) {
		try {
		element.sendKeys(value);
		}catch(NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			
		}
	}
	
	
	

	public void click(WebElement element) {
		try {
		element.click();
	} catch(NullPointerException | NoSuchElementException e){
		e.printStackTrace();
		Assert.fail();
	}
		
	}
}
