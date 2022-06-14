package testNg;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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

public class OnlineCalculatorTesting {

	private WebDriver driver;
	private Actions actions;
	private WebElement div;

	private final String TEST_URL = "https://www.calculator.net";

	@Test
	public void testMultiplication() {
		Double N1 = 423d;
		Double N2 = 525d;

		String input = String.format("%s*%s", N1, N2);

		System.out
				.println(String.format("Testing multiplication method of calculator for input:[%s] and [%s].", N1, N2));
		actions.moveToElement(div).sendKeys(input).perform();

		WebElement webElem = driver.findElement(By.xpath("//*[@id='sciOutPut']"));

		// String.trim() is used, to remove the white space from string result.
		double mulResult = Double.valueOf(webElem.getText().trim());

		Assert.assertEquals(222075.0, mulResult, 0);
		System.out.println("Test case for multiplication PASSED and result: " + mulResult);
	}

	@Test
	public void testDivision() {
		Double N1 = 4000d;
		Double N2 = 200d;

		String input = String.format("%s/%s", N1, N2);

		System.out.println(String.format("Testing division method of calculator for input:[%s] and [%s].", N1, N2));

		actions.moveToElement(div).sendKeys(input).perform();

		WebElement webElem = driver.findElement(By.xpath("//*[@id='sciOutPut']"));

		// String.trim() is used, to remove the white space from string result.
		double divResult = Double.valueOf(webElem.getText().trim());

		Assert.assertEquals(20.0, divResult, 0);
		System.out.println("Test case for division PASSED and result: " + divResult);
	}

	@Test
	public void testAddition() {
		Double N1 = -234234d;
		Double N2 = 345345d;

		String input = String.format("%s+%s", N1, N2);

		System.out.println(String.format("Testing addition method of calculator for input:[%s] and [%s].", N1, N2));

		actions.moveToElement(div).sendKeys(input).perform();

		WebElement webElem = driver.findElement(By.xpath("//*[@id='sciOutPut']"));

		// String.trim() is used, to remove the white space from string result.
		double addsResult = Double.valueOf(webElem.getText().trim());

		Assert.assertEquals(111111.0, addsResult, 0);
		System.out.println("Test case for addition PASSED and result: " + addsResult);
	}

	@Test
	public void testSubstraction() {

		Integer N1 = 234823;
		Integer N2 = -23094823;

		String input = String.format("%s-(%s)", N1, N2);

		System.out.println(String.format("Testing substraction method of calculator for input:[%s] and [%s].", N1, N2));

		actions.moveToElement(div).sendKeys(input).perform();

		WebElement webElem = driver.findElement(By.xpath("//*[@id='sciOutPut']"));

		// String.trim() is used, to remove the white space from string result.
		double subsResult = Double.valueOf(webElem.getText().trim());

		Assert.assertEquals(23329646, subsResult, 0);
		System.out.println("Test case for substraction PASSED and result: " + subsResult);
	}

	@BeforeMethod
	public void beforeMethod() {
		// Launch crome driver.
		System.setProperty("webdriver.chrome.driver", ".//Automationjar//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(TEST_URL);

		actions = new Actions(driver);
		div = driver.findElement(By.xpath("//*[@id=\"sciInPut\"]"));
	}

	@AfterMethod
	public void afterMethod() {
		// Adding sleep, just to keep browser open for sometime.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException exp) {
			System.out.println("Error: Got exception in afterMethod()." + exp.getMessage());
		}

		// To close the chrome browser used for last test case.
		driver.close();
	}

	@BeforeClass
	public void beforeClass() {
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
