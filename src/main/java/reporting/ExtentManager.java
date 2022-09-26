package reporting;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extentReports;
	
	public static ExtentReports initiatingReport() {
		if (extentReports == null) {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("MMddyyyy_hh.mm");
			String extension = format.format(date);
			extentReports = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReports/ExtentReport_"+extension+".html");
			spark.config().setReportName("TruistBnak Test Report");
			extentReports.attachReporter(spark);
			extentReports.setSystemInfo("Team", "QA");
			extentReports.setSystemInfo("Environment", "QA");
			extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
			extentReports.setSystemInfo("Tester", System.getProperty("user.name"));
		}
		return extentReports;
	}
}
