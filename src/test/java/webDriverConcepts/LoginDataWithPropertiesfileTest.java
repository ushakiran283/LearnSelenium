package webDriverConcepts;

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

public class LoginDataWithPropertiesfileTest {

	WebDriver driver;
	Properties prop;
	FileInputStream fis;

	@BeforeTest
	public void InitialSetup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webs.com/s/login/relogin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void login() throws IOException, InterruptedException {
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\data.properties");
		prop.load(fis);
		driver.findElement(By.xpath("//input[@name='j_username']")).clear();
		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		Thread.sleep(2000);

	}
}
