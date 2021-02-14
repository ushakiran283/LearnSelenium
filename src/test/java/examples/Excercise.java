package examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Excercise {

	static WebDriver driver;

	private static Logger log = LogManager.getLogger(Excercise.class.getName());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		Excercise ex = new Excercise();
		ex.testExcercise();
	}

	public void testExcercise() throws InterruptedException {
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
		Select s = new Select(driver.findElement(By.xpath("//select[@name='adults']")));
		Thread.sleep(3000);
		s.selectByIndex(2);
		Select s1 = new Select(driver.findElement(By.id("Childrens")));
		s1.selectByIndex(2);
		driver.findElement(By.xpath("//strong[contains(text(),'More options:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("AirIndia");
		driver.findElement(By.id("SearchBtn")).click();
		// System.out.println("Error Message :" +
		// driver.findElement(By.id("homeErrorMessage")).getText());
		log.error("Error Message :" + driver.findElement(By.id("homeErrorMessage")).getText());
		driver.close();
	}
}
