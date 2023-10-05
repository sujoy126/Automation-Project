package com.parle.PomClasses;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(name ="productname")
	private WebElement productNameTextBox;
	public WebElement getProductNameTextBox() {
		return productNameTextBox;
	}
	
	@FindBy(id ="productcode") //  remove 'e' from productcode  
	private WebElement partNumberTextBox;
	public WebElement getPartNumberTextBox() {
		return partNumberTextBox;
	}
	
	@FindBy(name = "button")
	private WebElement saveButton;
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	

}
