package webDriverConcepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginWithMultipleDataUsingExcel {

	WebDriver driver;
	File file;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	int rowcount;
	int cellcount;
	FileOutputStream fos;

	@BeforeTest
	public void InitialSetup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webs.com/s/login/relogin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	// Read Data from excel, get Data and print it in console
	public void GetLoginData() throws IOException, InterruptedException {
		// Imort Excel sheet
		file = new File(System.getProperty("user.dir") + "\\resources\\Testdata.xlsx");
		// Load the file
		fis = new FileInputStream(file);
		// Load the workbook
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which Data is present
		sheet = workbook.getSheetAt(0);
		// get rows
		rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(rowcount);
		// Print each cell data present in rows
		for (int i = 0; i <= rowcount; i++) {
			cellcount = sheet.getRow(i).getLastCellNum();
			System.out.println("Row" + i + "data is:");
			for (int j = 0; j < cellcount; j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue() + ",");
			}
			System.out.println();
		}

	}

	@Test
	public void Login() throws IOException, InterruptedException {
		GetLoginData();
		for (int i = 1; i <= rowcount; i++) {
			String cell = sheet.getRow(i).getCell(0).getStringCellValue();
			driver.findElement(By.xpath("//input[@name='j_username']")).clear();
			driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys(cell);
			String cell1 = sheet.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.xpath("//input[@type='password']")).clear();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(cell1);
			driver.findElement(By.xpath("//span[text()='Sign In']")).click();
			Thread.sleep(2000);
			// Write data to excel sheet
			fos = new FileOutputStream(file);
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
