package com.truist.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import commons.CommonWaits;
import commons.Commons;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.AffordabilityCalculatorPage;
import objects.OpenAccountPage;
import objects.OpenCheckingSavingAccPage;
import objects.OpenMortgagePage;
import utils.Configuration;

public class Base {
public Configuration configuration = new Configuration(null);
	
	WebDriver driver;
	WebDriverWait wait;
		
	CommonWaits waits;
	protected Commons commons;
	protected OpenAccountPage openAccountPage;
	protected OpenCheckingSavingAccPage openCheckingSavingAccPage;
	protected OpenMortgagePage openMortgagePage;
	protected AffordabilityCalculatorPage affordabilityCalculatorPage;
	
	@Parameters("browser")
	@BeforeMethod 
	
	public void setUp(String browser1) {
		driver=localDriver(browser1);
		driver.get(configuration.getConfiguration("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
		wait= new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("explicitWait"))));
		initClasses();
		
	}
	 
	private WebDriver localDriver(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("safaridriver")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		return driver;
	}
	
	protected void initClasses() {
		waits = new CommonWaits(wait);
		commons = new Commons(driver, waits);
		openAccountPage=new OpenAccountPage(driver, commons);
		openCheckingSavingAccPage =new OpenCheckingSavingAccPage(driver, commons);
		openMortgagePage =new OpenMortgagePage(driver, commons);
		affordabilityCalculatorPage = new AffordabilityCalculatorPage(driver, commons);
		
		
		
	}
	
//	protected WebDriver getDriver() {
//		return driver;
//	}
	
	
	@AfterMethod
	public void terminate() {
//		driver.quit();
	}
	
	
}
