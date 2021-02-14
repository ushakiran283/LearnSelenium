package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentReports extent;

	public static ExtentReports getReport() {
		String path = System.getProperty("user.dir") + "\\HTMLReports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
