package excercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDataUsingParametersTest {

	WebDriver driver;

	@BeforeTest
	public void InitialSetup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@Test(dataProvider = "getData")
	public void login(String username, String password) throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys(username);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.xpath("//button[@name='login']"));
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[1][2];
		obj[0][0] = "nimmagaddaushakiran@gmail.com";
		obj[0][1] = "ushakiran283";
		return obj;
	}

}
