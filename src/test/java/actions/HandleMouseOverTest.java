package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleMouseOverTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/menu/#");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Main Item 2']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='SUB SUB LIST �']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"))).perform();

		Thread.sleep(2000);
		driver.quit();

	}

}
