package webDriverConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingCalender {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#travel_date")).click();
		// Select Month as April
		while (!driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"))
				.getText().contains("April")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
		}

		// Select date as 23 // we identified common attribute class ='day'
		List<WebElement> date = driver.findElements(By.cssSelector(".day"));
		System.out.println(date.size());
		for (int i = 1; i < date.size(); i++) {
			String datetext = date.get(i).getText();
			if (datetext.equalsIgnoreCase("23")) {
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}

	}

}
