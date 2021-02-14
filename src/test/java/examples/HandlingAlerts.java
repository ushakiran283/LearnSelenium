package examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlerts {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		HandlingAlerts elements = new HandlingAlerts();
		elements.testHandlingAlerts();

	}

	public void testHandlingAlerts() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("usha");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Alert al = driver.switchTo().alert();
		System.out.println("Alert has:" + al.getText());
		al.accept();
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println("Alert has:" + al.getText());
		al.dismiss();
		driver.quit();
	}

}
