package webDriverConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingAllUIElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		HandlingAllUIElements elements = new HandlingAllUIElements();
		elements.testAllUIElements();

	}

	// Select from Delhi to chennai on current date with passenger of 2/3 adults and
	// click on search
	public void testAllUIElements() throws InterruptedException {
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		System.out.println(driver.findElement(By.xpath("//div[text()='1 Adult']")).getText());
		driver.findElement(By.xpath("//div[text()='1 Adult']")).click();
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s.selectByIndex(3);
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(2000L);
		driver.quit();
	}

}
