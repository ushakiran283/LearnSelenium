package excercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExcerciseOnTableTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		WebElement table = driver.findElement(By.id("product"));
		// Print No of rows present in the table
		System.out.println(table.findElements(By.tagName("tr")).size());
		// Print No of columns present in the table
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		// Print 2nd row content
		List<WebElement> row2 = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(row2.get(0).getText());
		System.out.println(row2.get(1).getText());
		System.out.println(row2.get(2).getText());

	}

}
