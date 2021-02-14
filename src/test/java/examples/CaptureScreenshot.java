package examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(examples.ListenersNG.class)
public class CaptureScreenshot {

	WebDriver driver;

	@BeforeTest
	public void InitialSetup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
	}

	@Test
	public void test01() throws InterruptedException {
		System.out.println("Title is :" + driver.getTitle());
		Thread.sleep(2000);
	}

	@Test
	public void test02() throws InterruptedException {
		driver.findElement(By.linkText("Downloads")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Downloads']")), "Downloads");
		driver.findElement(By.cssSelector(".releases-button1")).click();
		Thread.sleep(2000);
	}

	public void getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\FailedScreenshots\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(destination));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
