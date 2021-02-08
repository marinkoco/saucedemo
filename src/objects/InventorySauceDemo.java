package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventorySauceDemo {
	
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	public static final String DROP_DOWN_MENU_XPATH = "//*[@id=\"inventory_filter_container\"]/select";
	
	public static void sort(WebDriver driver) {	
	Select dropDownSort = new Select(driver.findElement(By.xpath(DROP_DOWN_MENU_XPATH)));
	dropDownSort.selectByVisibleText("Price (low to high)");
		
	}
}
