package excercise;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExcerciceOnKeyboardActionsTest {

	WebDriver driver;

	@BeforeTest
	public void InitialSetup() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/register");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void keyboard() throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement firstname = driver.findElement(By.cssSelector("#firstname"));
		action.keyDown(firstname, Keys.SHIFT).sendKeys(firstname, "ushakrian").keyUp(firstname, Keys.SHIFT)
				.sendKeys(Keys.TAB).sendKeys("battini", Keys.ENTER).sendKeys(Keys.TAB)
				.sendKeys("durgaprasad", Keys.ENTER).sendKeys(Keys.TAB).sendKeys("usha@3", Keys.ENTER).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#register")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("#name")).getText(),
				"Please verify reCaptcha to register!");
		Thread.sleep(2000);

	}

}
