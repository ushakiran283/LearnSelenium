package examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Excercise4 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// checkbox
		driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		// String opt =
		// driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		String opt = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
		System.out.println(opt);
		// dropdown
		Select s = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
		// s.selectByVisibleText(opt);
		s.selectByValue(opt);
		// Alert
		driver.findElement(By.cssSelector("#name")).sendKeys(opt);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		Alert al = driver.switchTo().alert();
		String option2text = al.getText();
		if (option2text.contains(opt)) {
			System.out.println("Alert message success");
		}
		al.accept();
		Thread.sleep(2000);
	}

}
