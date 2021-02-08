package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.HomeSauceDemo;
import objects.InventorySauceDemo;

public class TestSauceDemo {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void testLoginWrong() {

		File f = new File("data.xlsx");
		try {
			InputStream inp = new FileInputStream(f); 
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(0);
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);

			String username = c1.toString();
			String password = c2.toString();

			driver.navigate().to(HomeSauceDemo.URL);
			HomeSauceDemo.inputUsername(driver, username);
			HomeSauceDemo.inputPassword(driver, password);
			HomeSauceDemo.login(driver);

			String actual = driver.getCurrentUrl();
			String expected = "https://www.saucedemo.com/inventory.html";

			Assert.assertEquals(actual, expected, username);

			wb.close();

		} catch (

		IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void testLoginCorrect() {

		File f = new File("data.xlsx");
		try {
			InputStream inp = new FileInputStream(f); 
			XSSFWorkbook wb = new XSSFWorkbook(inp); 
			Sheet sheet = wb.getSheetAt(0); 
			Row row = sheet.getRow(1);
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);

			String username = c1.toString();
			String password = c2.toString();

			driver.navigate().to(HomeSauceDemo.URL);
			HomeSauceDemo.inputUsername(driver, username);
			HomeSauceDemo.inputPassword(driver, password);
			HomeSauceDemo.login(driver);

			String actual = driver.getCurrentUrl();
			String expected = "https://www.saucedemo.com/inventory.html";

			Assert.assertEquals(actual, expected, username);

			wb.close();

		} catch (

		IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void sortTest() {
		driver.navigate().to(InventorySauceDemo.URL);
		WebElement element = driver.findElement(By.xpath(InventorySauceDemo.DROP_DOWN_MENU_XPATH));
		Select se = new Select(element);
		se.selectByVisibleText("Price (low to high)");
		
		List<String> originalList = new ArrayList();
		for (WebElement e : se.getOptions()) {
			originalList.add(e.getText());
		}

		List<String> tempList = originalList;
		Collections.sort(tempList);
		Assert.assertEquals(tempList, originalList);

	}
}
