package com.parle.PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement userNameTextBox;
	
	@FindBy(name="user_password")
	private WebElement passwordTextBox;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutButton;
	
	public WebElement getUserNameTextBox() {
		return userNameTextBox;
	}
	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getLogoutButton() {
		return signoutButton;
	}
	

}
