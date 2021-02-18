package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ExcerciseOnKeyboardActionsTest {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement fullname = driver.findElement(By.cssSelector("#userName"));
		WebElement email = driver.findElement(By.cssSelector("#userEmail"));

		Actions action = new Actions(driver);
		action.keyDown(fullname, Keys.SHIFT).sendKeys(fullname, "ushakiran").keyUp(fullname, Keys.SHIFT)
				.sendKeys(Keys.TAB).sendKeys(email, Keys.ENTER).sendKeys(Keys.TAB)
				.sendKeys("d/o:4-136, RiceMillBazar, Medikonduru(MD),Guntur(Dst)" + Keys.ENTER).keyDown(Keys.CONTROL)
				.sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL)
				.sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.TAB).build()
				.perform();

		driver.findElement(By.cssSelector("#submit")).click();
		driver.quit();
	}

}
