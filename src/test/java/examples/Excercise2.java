package examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Excercise2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		Excercise2 ex = new Excercise2();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);// wait is
		// applied to each and every line of
		// test
		// ex.testExcercise2();
		ex.testExcerciseReq2();

	}

	// Req1 : add only item to the cart
	public void testExcercise2() {
		// Add few items to the cart
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name")); // 30 elements matching
		for (int i = 0; i < items.size(); i++) {
			String itemname = items.get(i).getText();// print all the elements by comparing each element
			System.out.println("Items are :" + itemname);
			if (itemname.contains("Cucumber")) {
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}

	}

	// Req2 : Add few items {"Brocolli, Cucumber, Beetroot"}to the cart
	public void testExcerciseReq2() {
		int j = 0;

		String[] itemsNeeded = { "Brocolli", "Cucumber", "Tomato" };

		// Add few items to the cart
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name")); // 30 elements matching
		for (int i = 0; i < items.size(); i++) {

			// Brocolli - 1 Kg (Split with -)
			// Converted to array
			// [Brocolli ] , [1 kg]
			String[] itemname = items.get(i).getText().split("-");// print all the elements by comparing each element
			String formatteditem = itemname[0].trim(); // trim remove spaces

			// System.out.println("Items are :" + formatteditem);

			// Convert whether name you extract is present in array or not to do that you
			// need to convert array to arraylist
			List itemsNeededList = Arrays.asList(itemsNeeded);
			// System.out.println("Items Needed List are : " + itemsNeededList);
			if (itemsNeededList.contains(formatteditem)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == 3) {
					break;
				}
			}
		}
		testExecerciseReq3();

	}

	// Req3: Clcik on the card an proceed to checkout
	public void testExecerciseReq3() {
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		// WebDriverWait class
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));

	}
}
