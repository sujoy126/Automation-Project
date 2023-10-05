package com.parle.PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	@FindBy(css = "img[title='Create Product...']")
	private WebElement createProductButton;
	
	public WebElement getcreateProductButton() {
		return createProductButton;
	}

}
