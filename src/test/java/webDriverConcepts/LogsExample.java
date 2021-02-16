package webDriverConcepts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LogsExample {
	private static Logger log = LogManager.getLogger(LogsExample.class.getName());

	public static void main(String[] args) {
		log.debug("Setting chrome driver property");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Window Maximized"); // info- tells the information
		log.debug("Now hitting Amazon server"); // debug - tells when actions are performed
		driver.get("https://www.amazon.com/");
		log.info("Landed on amazon home page");
		Actions a = new Actions(driver);

		/*
		 * a.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")
		 * ))
		 * .click().keyDown(Keys.SHIFT).sendKeys("capitalletters").doubleClick().build()
		 * .perform(); a.moveToElement(driver.findElement(By.cssSelector(
		 * "a[id='nav-link-accountList']"))).build().perform();
		 * a.moveToElement(driver.findElement(By.cssSelector(
		 * "a[id='nav-link-accountList']"))).contextClick().build().perform();
		 */

		driver.get("http://jqueryui.com/demos/droppable/");
		log.debug("Getting the frames count");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		log.info("Frames count retreived");
		try {
			driver.switchTo().frame(0);
			log.info("Successfully switched to frame");
		} catch (Exception e) {
			log.error("Cannot identify the frame");
		}
		// driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		log.debug("Identifying Draggable objects");
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		new Actions(driver).dragAndDrop(draggable, droppable).build().perform();
		log.info("Drag and drop success");
		driver.close();
	}

}