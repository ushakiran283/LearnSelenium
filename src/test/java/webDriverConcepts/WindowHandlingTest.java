package webDriverConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandlingTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".blinkingText")).click(); // open a new tab/window
		Set<String> windows = driver.getWindowHandles(); // [parenid, childid]
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		Thread.sleep(2000);
		String emailid = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim()
				.split(" ")[0];
		Thread.sleep(2000);
		driver.switchTo().window(parentid);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#username")).sendKeys(emailid);
	}
}
