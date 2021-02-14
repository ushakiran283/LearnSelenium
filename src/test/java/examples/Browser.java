package examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Browser {

	WebDriver driver;

	public void browser(String browser) {
		if (browser == "chrome") {
			System.setProperty("webdriver.chrome.driver",
					"E:\\SeleniumNotes&Jars\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser == "firefox") {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser is not correct");
		}

	}

	public void testCheckbox() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		// To check the checkbox
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		// Verify the checkbox is checked or not
		// System.out.println(driver.findElement(By.xpath("//
		// input[@id='checkBoxOption1']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("// input[@id='checkBoxOption1']")).isSelected());

		// To uncheck the checkbox
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		// System.out.println(driver.findElement(By.xpath("//
		// input[@id='checkBoxOption1']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("// input[@id='checkBoxOption1']")).isSelected());

		// Verify checkboxes
		// System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 3);
		teardown();
	}

	public void testDropdownUsingSelectClass() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByIndex(2);
		System.out.println("Selected Dropdwon is :" + s.getFirstSelectedOption().getText());
		teardown();
	}

	public void testDropdownLoopingUI() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		// click + button 5 times
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.xpath("//input[@value='Done']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());

		teardown();
	}

	public void testDynamicDropdownUsingIndex() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@value='Departure City']")).click();
		driver.findElement(By.xpath("//a[text()=' Bengaluru (BLR)']")).click();
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		teardown();
	}

	public void testDynamicDropdownUsingParent_Child() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@value='Departure City']")).click();
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[text()=' Bengaluru (BLR)']"))
				.click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		teardown();
	}

	public void testAutoSuggestions() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options) {
			// System.out.println("Opions are :" + option.getText());
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
			}
		}
		teardown();
	}

	public void testCurrentCalender() throws InterruptedException {
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//input[@value='Departure City']")).click();
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[text()=' Bengaluru (BLR)']"))
				.click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		Thread.sleep(2000);
		teardown();
	}

	public void testRadiobutton() throws InterruptedException {
		driver.get("https://www.spicejet.com/");

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			// System.out.println("Radio button is enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);

		}
		teardown();
	}

	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
