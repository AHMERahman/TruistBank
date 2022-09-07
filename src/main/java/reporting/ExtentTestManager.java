package reporting;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class ExtentTestManager {
	
	public static Map<Integer, ExtentTest> tests = new HashMap<Integer, ExtentTest>();
	private static ExtentReports extentReports = ExtentManager.initiatingReport();
	
	public static synchronized ExtentTest creatingTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		tests.put((int)(long) Thread.currentThread().getId(), test);
		return test;
	}
	
	public static synchronized ExtentTest getTest() {
		return tests.get((int)Thread.currentThread().getId());
	}

}
