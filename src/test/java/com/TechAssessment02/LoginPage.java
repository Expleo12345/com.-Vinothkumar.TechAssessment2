package com.TechAssessment02;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
	WebDriver driver;
	By mailId = By.xpath("//input[@class='email']");
	By passWod = By.xpath("//*[@id=\"Password\"]");
	By login = By.xpath("//input[@class='button-1 login-button']");
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//for username
	public void enterEmailId(String user) {
		driver.findElement(mailId).sendKeys(user);
	}
	//for password
	public void enterLoginPassword(String pass) {
		driver.findElement(passWod).sendKeys(pass);
	}
	//for clicking login button
	public void clickButton() {
		driver.findElement(login).click();
	}
	public void login(String user, String pass) {
		this.enterEmailId(user);
		this.enterLoginPassword(pass);
		this.clickButton();
	}
}

