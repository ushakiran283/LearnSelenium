package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleDragAndDrop {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement from = driver.findElement(By.cssSelector("#draggable"));
		WebElement to = driver.findElement(By.cssSelector("#droppable"));

		Actions action = new Actions(driver);
		action.dragAndDrop(from, to).perform();

		// Verify the text once dropped
		String text = to.getText();
		if (text.equalsIgnoreCase("Dropped!")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

		Thread.sleep(2000);
		driver.quit();

	}

}
