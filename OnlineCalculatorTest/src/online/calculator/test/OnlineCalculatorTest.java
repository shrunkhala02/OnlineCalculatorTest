package online.calculator.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class OnlineCalculatorTest {

	private WebDriver driver;
	private Actions actions;
	private WebElement div;

	private final String TEST_URL = "https://www.calculator.net";
	private final int N1_COL = 0;
	private final int N2_COL = 1;
	private final int OUTPUT_COL = 2;

	private final String INPUT_X_PATH = "//*[@id=\"sciInPut\"]";
	private final String OUTPUT_X_PATH = "//*[@id='sciOutPut']";

	XSSFSheet sheet1;

	@Test(priority = 1)
	public void testMultiplication() throws Exception {
		long N1 = (long) sheet1.getRow(1).getCell(N1_COL).getNumericCellValue();

		String input1 = String.valueOf(N1);
		long N2 = (long) sheet1.getRow(1).getCell(N2_COL).getNumericCellValue();
		String input2 = String.valueOf(N2);

		// Read input to calculator.
		WebElement div = driver.findElement(By.xpath(INPUT_X_PATH));

		actions.moveToElement(div).sendKeys(input1).perform();

		// "(//*[@class='sciop'])[5]" is Locator for multiplication symbol.
		driver.findElement(By.xpath("(//*[@class='sciop'])[5]")).click();

		actions.moveToElement(div).sendKeys(input2).perform();

		// Checking the result

		long res = (long) sheet1.getRow(1).getCell(OUTPUT_COL).getNumericCellValue();
		String result = String.valueOf(res);
		WebElement webElem = driver.findElement(By.xpath(OUTPUT_X_PATH));

		// String.trim() is used, to remove the white space from string result.
		long multResult = Long.valueOf(webElem.getText().trim());

		String actual = String.valueOf(multResult);
		Assert.assertEquals(actual, result);
		System.out.println("Test case for Addition PASSED and result: " + actual);
	}

	@Test(priority = 2)
	public void testDivision() throws Exception {
		long N1 = (long) sheet1.getRow(2).getCell(N1_COL).getNumericCellValue();

		String input1 = String.valueOf(N1);
		long N2 = (long) sheet1.getRow(2).getCell(N2_COL).getNumericCellValue();
		String input2 = String.valueOf(N2);

		// Read input to calculator.
		WebElement div = driver.findElement(By.xpath(INPUT_X_PATH));

		actions.moveToElement(div).sendKeys(input1).perform();

		// "(//*[@class='sciop'])[8]" is Locator for division symbol.
		driver.findElement(By.xpath("(//*[@class='sciop'])[8]")).click();

		actions.moveToElement(div).sendKeys(input2).perform();

		// Checking the result

		long res = (long) sheet1.getRow(2).getCell(OUTPUT_COL).getNumericCellValue();
		String result = String.valueOf(res);
		WebElement webElem = driver.findElement(By.xpath(OUTPUT_X_PATH));

		// String.trim() is used, to remove the white space from string result.
		long divResult = Long.valueOf(webElem.getText().trim());

		String actual = String.valueOf(divResult);
		Assert.assertEquals(actual, result);
		System.out.println("Test case for Division PASSED and result: " + actual);

	}

	@Test(priority = 3)
	public void testAddition() throws Exception {
		long N1 = (long) sheet1.getRow(3).getCell(N1_COL).getNumericCellValue();

		String input1 = String.valueOf(N1);
		long N2 = (long) sheet1.getRow(3).getCell(N2_COL).getNumericCellValue();
		String input2 = String.valueOf(N2);

		// Read input to calculator.
		WebElement div = driver.findElement(By.xpath(INPUT_X_PATH));

		actions.moveToElement(div).sendKeys(input1).perform();

		// "(//*[@class='sciop'])[1]" is Locator for addition symbol.
		driver.findElement(By.xpath("(//*[@class='sciop'])[1]")).click();

		actions.moveToElement(div).sendKeys(input2).perform();

		// Checking the result

		long res = (long) sheet1.getRow(3).getCell(OUTPUT_COL).getNumericCellValue();
		String result = String.valueOf(res);
		WebElement webElem = driver.findElement(By.xpath(OUTPUT_X_PATH));

		// String.trim() is used, to remove the white space from string result.
		long addResult = Long.valueOf(webElem.getText().trim());

		String actual = String.valueOf(addResult);
		Assert.assertEquals(actual, result);
		System.out.println("Test case for Addition PASSED and result: " + actual);

	}

	@Test(priority = 4)
	public void testSubstraction() throws Exception {

		long N1 = (long) sheet1.getRow(4).getCell(N1_COL).getNumericCellValue();

		String input1 = String.valueOf(N1);
		long N2 = (long) sheet1.getRow(4).getCell(N2_COL).getNumericCellValue();
		String input2 = String.valueOf(N2);

		// Read input to calculator.
		WebElement div = driver.findElement(By.xpath(INPUT_X_PATH));

		actions.moveToElement(div).sendKeys(input1).perform();

		// "(//*[@class='sciop'])[3]" is Locator for subtraction symbol.
		driver.findElement(By.xpath("(//*[@class='sciop'])[3]")).click();

		actions.moveToElement(div).sendKeys((input2)).perform();

		// Checking the result

		long res = (long) sheet1.getRow(4).getCell(OUTPUT_COL).getNumericCellValue();
		String result = String.valueOf(res);
		WebElement webElem = driver.findElement(By.xpath(OUTPUT_X_PATH));

		// String.trim() is used, to remove the white space from string result.
		long subResult = Long.valueOf(webElem.getText().trim());

		String actual = String.valueOf(subResult);
		Assert.assertEquals(actual, result);
		System.out.println("Test case for Subtraction PASSED and result: " + actual);

	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		// Launch chromedriver
		System.setProperty("webdriver.chrome.driver", ".//Automationjar//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(TEST_URL);

		actions = new Actions(driver);
	}

	@AfterMethod
	public void afterMethod() {
		// Adding sleep, just to keep browser open for sometime.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException exp) {
			System.out.println("Error: Got exception in afterMethod()." + exp.getMessage());
		}

		// To close the chrome browser used for last test case.
		driver.close();
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		// Adding the implementation for reading excel file, for taking input for test
		// cases.
		// Adding in beforeClass() method, as we only want to read this file once.
		File src = new File("D:\\\\Excel\\\\OnlineCalculator.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook x1 = new XSSFWorkbook(fis);

		sheet1 = x1.getSheetAt(0);
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
