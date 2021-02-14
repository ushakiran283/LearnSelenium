package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleKeyboardActions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		Actions act = new Actions(driver);
		// first the element should be focused
		// keydown-Press CONTROL,SHIFT,ALT keys
		// Keyup-keyboard key which press using keydown() method dowsn't get released
		// automatically so keyup should e used explicitly
		WebElement text = driver.findElement(By.xpath("//input[@name='q']"));
		act.keyDown(text, Keys.SHIFT).sendKeys(text, "hello").keyUp(text, Keys.SHIFT).doubleClick(text).contextClick()
				.build().perform();

	}

}
