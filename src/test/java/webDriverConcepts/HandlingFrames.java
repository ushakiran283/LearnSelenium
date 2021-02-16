package webDriverConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingFrames {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
		System.out.println("No of frames:" + frame.size());
		// Handle frames by index and locator
		// driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		// // By locator
		driver.switchTo().frame(0); // By Index
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		WebElement destination = driver.findElement(By.cssSelector("#droppable"));
		action.dragAndDrop(source, destination).build().perform();

		// you are in frame and you need to switch to main page in order to perfrom
		// normal operaions we have method "default content"
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Accept']")).click();

	}

}
