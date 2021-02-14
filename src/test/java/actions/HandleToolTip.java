package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleToolTip {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/buttons");
		WebElement rightclickbtn = driver.findElement(By.cssSelector("#rightClickBtn"));

		Actions action = new Actions(driver);
		action.doubleClick(rightclickbtn).perform();
		Thread.sleep(2000);
		driver.quit();

	}

}
