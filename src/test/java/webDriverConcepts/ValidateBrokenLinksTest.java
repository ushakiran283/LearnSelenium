package webDriverConcepts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

public class ValidateBrokenLinksTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']//a"));

		// Instead of writing if loop we can write TestNG Assertion i.e soft Assert
		SoftAssert a = new SoftAssert();

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responsecode = connection.getResponseCode();
			System.out.println(responsecode);
			/*
			 * if (responsecode > 400) { System.out.println("The link with text is " +
			 * link.getText() + "is broken with code" + responsecode);
			 * Assert.assertTrue(false); }
			 */
			a.assertTrue(responsecode < 400,
					"The link with text is " + link.getText() + "is broken with code" + responsecode);

		}
		a.assertAll();
	}
}
