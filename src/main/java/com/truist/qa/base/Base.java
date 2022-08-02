package com.truist.qa.base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commons.Commons;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.OpenAccountPage;
import utils.Configuration;

public class Base {
public Configuration configuration = new Configuration(null);
	
	WebDriver driver;
	protected OpenAccountPage openAccountPage;
	protected Commons commons;
	

	@BeforeMethod 
	
	public void setUp() {
		driver=localDriver("chrome");
		driver.get(configuration.getConfiguration("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
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
		commons = new Commons();
		openAccountPage=new OpenAccountPage(driver, commons);
		
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
	
	
	@AfterMethod
	public void terminate() {
		driver.quit();
	}
	
	
}
