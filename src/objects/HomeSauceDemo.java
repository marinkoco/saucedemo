package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeSauceDemo {
	
	public static final String URL = "https://www.saucedemo.com/";
	private static final String USER_NAME_XPATH = "//*[@id=\"user-name\"]";
	private static final String PASSWORD_XPATH = "//*[@id=\"password\"]";
	private static final String LOGIN_XPATH = "//*[@id=\"login-button\"]";
	
	public static void inputUsername(WebDriver driver, String username) {
		driver.findElement(By.xpath(USER_NAME_XPATH)).sendKeys(username);	
	}
	public static void inputPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(password);
	}
	
	public static void login(WebDriver driver) {
		driver.findElement(By.xpath(LOGIN_XPATH)).click();
	}

}
