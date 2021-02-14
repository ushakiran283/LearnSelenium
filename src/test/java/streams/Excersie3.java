package streams;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Excersie3 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");
		List<WebElement> elementslist = driver.findElements(By.xpath("//tr/td[1]"));
		// 1 element
		List<WebElement> filteredlist = elementslist.stream().filter(s -> s.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(elementslist.size(), filteredlist.size());

	}

}
