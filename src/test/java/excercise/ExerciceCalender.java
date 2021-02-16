package excercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExerciceCalender {
	WebDriver driver;

	@BeforeTest
	public void InitialSetup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/date-picker");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@Test
	public void Calender() throws InterruptedException {
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		// Select month as April
		while (!driver.findElement(By.xpath(
				"//div[@class='react-datepicker__header']//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']"))
				.getText().contains("November")) {
			driver.findElement(By.xpath("//button[text()='Next Month']")).click();
		}
		// Now Select year as 1991
		WebElement dropdown = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
		Select s = new Select(dropdown);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			String optiontext = option.getText();
			if (optiontext.equalsIgnoreCase("1991")) {
				option.click();
			}
		}

		Thread.sleep(2000);
		// Now select the DATE as 6
		List<WebElement> week = driver
				.findElements(By.xpath("//div[@class='react-datepicker__week']//div[@role='option']"));
		for (int i = 0; i < week.size(); i++) {
			String text = week.get(i).getText();
			if (text.equalsIgnoreCase("1")) {
				week.get(i).click();
				break;
			}
		}

		Thread.sleep(3000);

	}

}
