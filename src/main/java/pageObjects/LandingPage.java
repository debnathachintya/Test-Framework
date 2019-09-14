package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	By userName = By.name("userName");
	By passWord = By.name("password");
	By login = By.name("login");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement user() {
		return driver.findElement(userName);
	}

	public WebElement pass() {
		return driver.findElement(passWord);
	}

	public WebElement login() {
		return driver.findElement(login);
	}
}