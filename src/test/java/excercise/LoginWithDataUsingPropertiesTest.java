package excercise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginWithDataUsingPropertiesTest {

	WebDriver driver;
	Properties prop;

	@BeforeTest
	public void InitialSetup() throws IOException {
		String path = System.getProperty("user.dir") + "\\resources\\LoginData.properties";
		prop = new Properties();
		FileInputStream stream = new FileInputStream(path);
		prop.load(stream);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.cssSelector("#pass")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@name='login']"));
		Thread.sleep(2000);
	}

}
