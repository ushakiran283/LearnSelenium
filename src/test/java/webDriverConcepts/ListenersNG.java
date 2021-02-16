package webDriverConcepts;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.ExtentReporter;

public class ListenersNG extends CaptureScreenshot implements ITestListener {

	ExtentReporter ex;
	ExtentTest test;

	ExtentReports extent = ExtentReporter.getReport();

	public void onTestStart(ITestResult result) {
		// System.out.println("TestCase started:" + result.getName());
		// Instead of creating instance of ExtentReporter class, you can declare class
		// as static
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// System.out.println(result.getName() + ":TestCase Passed");
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// System.out.println("TestCase Failed is:" + result.getName());
		test.fail(result.getThrowable());
		WebDriver driver = null;

		String methodName = result.getMethod().getMethodName(); // automatically captures failed testcase name
		System.out.println("Capture methodname:" + methodName);

		// below try block will get fields of a class(driver-which is instance of class)
		// field(driver) which we are retrieving is WebDriver object.
		// so we created dummy "WebDriver object as null i.e WebDriver driver =null"
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			getScreenshot(methodName, driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// System.out.println("TestCase skipped is:" + result.getName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
