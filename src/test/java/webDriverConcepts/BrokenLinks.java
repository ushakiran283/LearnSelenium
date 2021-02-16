package webDriverConcepts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

		// Req 1 Get the Count of links present in the page
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println(driver.findElements(By.tagName("a")).size());
		// get the attribute of Broken link
		String url = driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");
		// Java methods to check the status of the link i.e 200/above 400

		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		int response = connection.getResponseCode();
		System.out.println(response);

	}
}
