package excercise;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Excercise1OnWindowHandlingTest {

	WebDriver driver;

	@BeforeTest
	public void InitialSetup() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void WindowHandle() throws InterruptedException {
		driver.findElement(By.cssSelector("#windowButton")).click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator(); // [parenid,childid]
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.cssSelector("#sampleHeading")).getText(), "This is a sample page");
		Thread.sleep(2000);
		driver.switchTo().window(parentid);
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void Alert() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='item-1']//span[text()='Alerts']")).click();
		driver.findElement(By.cssSelector("#confirmButton")).click();
		Alert al = driver.switchTo().alert();
		System.out.println("Text in alert box:" + al.getText());
		al.accept();
	}
}
