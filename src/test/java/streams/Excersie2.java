package streams;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Excersie2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator(); // [parentid,childid]
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		Thread.sleep(2000);

		// click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Capture all the webelements into list
		List<WebElement> elementslist = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all elements into original list
		List<String> originallsit = elementslist.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort the original list
		List<String> sortedlsit = originallsit.stream().sorted().collect(Collectors.toList());
		// compare original list vs sorted list
		Assert.assertTrue(originallsit.equals(sortedlsit));
		// scan the column with getText-Beans and print the price of Beans
		List<Object> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getpriceVeggie(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if (price.size() < 1) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	private static Object getpriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
