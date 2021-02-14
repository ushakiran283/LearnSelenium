package examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ScrollAndHandleTableGrid {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// to move the browser we have to use javascript concept i.e javascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		Thread.sleep(3000);
		// In Amount section, count the numbers and sum them
		List<WebElement> count = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int sum = 0;
		for (int i = 0; i < count.size(); i++) {
			// Wrapper class
			/*
			 * String s = count.get(i).getText(); Integer text = Integer.valueOf(s); sum +=
			 * text;
			 */
			// Instead of "valueOf" u can use "parseInt" method as well, to convert String
			// to int
			sum += Integer.parseInt(count.get(i).getText());
		}
		System.out.println(sum);

		// Compare "Total Amount collected:296" to Sum
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println(total);
		Assert.assertEquals(sum, total);
	}

}
