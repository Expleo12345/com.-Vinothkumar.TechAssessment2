package com.TechAssessment02;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage {
	WebDriver driver;
	By maleRadio = By.cssSelector("input#gender-male");
	By femaleRadio = By.cssSelector("input#gender-female");
	By firstName = By.xpath("//input[@id='FirstName']");
	By lastName = By.xpath("//input[@id='LastName']");
	By email = By.xpath("//input[@id='Email']");
	By newPassword = By.xpath("//input[@name='Password']");
	By confirmPassword = By.xpath("//input[@name='ConfirmPassword']");
	By register = By.xpath("//input[@id='register-button']");
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	public void selectGenderMale() {
	    driver.findElement(maleRadio).click();
	}
	public void selectGenderFemale() {
	    driver.findElement(femaleRadio).click();
	}
	public void enterFirstName(String name1) {
	    driver.findElement(firstName).sendKeys(name1);
	}
	public void enterLastName(String name2) {
	    driver.findElement(lastName).sendKeys(name2);
	}
	public void enterEmail(String myMail) {
	    driver.findElement(email).sendKeys(myMail);
	}
	public void enterPassword(String newPass) {
	    driver.findElement(newPassword).sendKeys(newPass);
	}
	public void enterConfirmPassword(String confirmPass) {
	    driver.findElement(confirmPassword).sendKeys(confirmPass);
	}
	public void clickRegister() {
	    driver.findElement(register).click();
	}
	public void register(String name1, String name2,String myMail,String newPass,String confirmPass) {
		this.selectGenderMale();
		this.selectGenderFemale();
		this.enterFirstName(name1);
		this.enterLastName(name2);
		this.enterEmail(myMail);
		this.enterPassword(newPass);
		this.enterConfirmPassword(confirmPass);
		this.clickRegister();
	}
 
}