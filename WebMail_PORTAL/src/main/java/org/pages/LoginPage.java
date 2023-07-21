package org.pages;

import org.configue.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	ConfigReader obj = new ConfigReader();
	private WebDriver driver;

	@FindBy (xpath="//input[@id='user']")
	private WebElement uNameField;

	@FindBy (xpath = "//input[@id='password']")
	private WebElement pwdField;

	@FindBy (xpath = "//button[normalize-space()='Sign In']")
	private WebElement loginBtn;
	
	@FindBy (xpath="//li[@class='nav-item dropdown not-search-item']//div[@id='navbarDropdown']")
	private WebElement beforelogbtn;

	@FindBy (xpath = "//div[@class='dropdown-menu dropdown-menu-right show']//div[2]")
	private WebElement logoutBtn;	


	public LoginPage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public boolean uNameFielddisplayed () {
	return uNameField.isDisplayed();
	}	
	public boolean pwdFielddisplayed () {
	return pwdField.isDisplayed();
	}
	public boolean loginFielddisplayed () {
	return loginBtn.isDisplayed();
	}
	
	public void enterUserName () {
		uNameField.sendKeys(obj.getTestData("username"));
	}
	public void enterpassword() {
		pwdField.sendKeys(obj.getTestData("password"));
	}
	public void clickOnLoginBtn () {
		loginBtn.click();
	}
	public void beforeclickOnLogoutBtn()  {
		beforelogbtn.click();
		
	}
	public void clickOnLogoutBtn() {
		logoutBtn.click();
	
		
	}
}
