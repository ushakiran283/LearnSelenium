package webDriverConcepts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAllLinksTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

		// Req 1 Count of links on the page
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Req 2 Count of links in footer section
		WebElement footerdriver = driver
				.findElement(By.xpath("//div[@class=' footer_top_agile_w3ls gffoot footer_style']"));// limiting
																										// webdriver
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// Req 3 Count of links in 1st section of footer section
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		List<WebElement> links = columndriver.findElements(By.tagName("a"));

		// Req 4 click on each link in the column and check if the pages are opening/not
		for (int i = 1; i < links.size(); i++) {

			String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			links.get(i).sendKeys(clickOnTab);
			Thread.sleep(2000);
		}

		// Req 5 Navigate to child tab/window and get the title
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

}
