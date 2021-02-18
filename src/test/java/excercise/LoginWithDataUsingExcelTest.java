package excercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginWithDataUsingExcelTest {

	WebDriver driver;

	@BeforeTest
	public void InitialSetup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	public void GetData() throws IOException {
		String path = System.getProperty("user.dir") + "\\resources\\SampleTestdata.xlsx";
		FileInputStream stream = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		// get No of rows
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println("No of Rows:" + rowCount);
		// get "cell data" in rows
		// int cellCount = sheet.getRow(1).getLastCellNum();
		// System.out.println("No columns:" + cellCount);
		for (int i = 1; i <= rowCount; i++) {
			int cellCount = sheet.getRow(i).getLastCellNum();
			System.out.println("Row " + i + " data is :");
			for (int j = 0; j < cellCount; j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue() + ",");
			}
			System.out.println(".......");
		}

	}

	@Test
	public void Login() throws IOException, InterruptedException {
		File file = new File(System.getProperty("user.dir") + "\\resources\\SampleTestdata.xlsx");
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		WebElement username = driver.findElement(By.cssSelector("#email"));
		WebElement password = driver.findElement(By.cssSelector("#pass"));
		WebElement loginbtn = driver.findElement(By.xpath("//button[@name='login']"));

		for (int i = 1; i <= rowcount; i++) {
			// int cellcount = sheet.getRow(i).getLastCellNum();
			// System.out.println("No of columns:" + cellcount);
			String cell = sheet.getRow(i).getCell(0).getStringCellValue();
			username.sendKeys(cell);
			String cell1 = sheet.getRow(i).getCell(1).getStringCellValue();
			password.sendKeys(cell1);
			loginbtn.click();
			Thread.sleep(3000);

			// Write data to excel sheet
			FileOutputStream fos = new FileOutputStream(file);
			// create cell and write a message
			String msg = "PASS";
			sheet.getRow(i).createCell(2).setCellValue(msg);
			// write content
			workbook.write(fos);
			Thread.sleep(2000);
			fos.close();

		}

	}

}
