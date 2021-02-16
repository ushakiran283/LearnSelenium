package excercise;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExcerciseonWindowHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> windows = driver.getWindowHandles(); // [parentidd, childid]
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		Thread.sleep(2000);
		System.out.println(
				"Child window text is :" + driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
		driver.switchTo().window(parentid);
		Thread.sleep(2000);
		System.out.println("Parent Window text is : "
				+ driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
	}

}
