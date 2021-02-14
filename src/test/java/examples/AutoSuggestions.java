package examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSuggestions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("ind");
		Thread.sleep(2000);

		List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
			}
		}
		System.out.println(driver.findElement(By.cssSelector("#autocomplete")).getAttribute("value"));

		/*
		 * // you can perform keyboard actions
		 * driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
		 * driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
		 * System.out.println(driver.findElement(By.cssSelector("#autocomplete")).
		 * getAttribute("value"));
		 */

	}
}
