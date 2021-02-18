package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ExerciceOnSliderTest {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/tooltip.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		WebElement hover = driver.findElement(By.cssSelector("#download_now"));
		action.moveToElement(hover).perform();
		WebElement text = driver.findElement(By.xpath("//div[@class='tooltip']"));
		action.moveToElement(text).perform();
		System.out.println(text.getText());

		driver.quit();

	}

}
