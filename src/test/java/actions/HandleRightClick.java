package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleRightClick {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/buttons");
		WebElement doubleclickbtn = driver.findElement(By.cssSelector("#doubleClickBtn"));

		Actions action = new Actions(driver);
		action.doubleClick(doubleclickbtn).perform();
		Thread.sleep(2000);
		driver.quit();

	}

}
