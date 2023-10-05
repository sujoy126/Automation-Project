package com.parle.PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath = "//a[text()='Calendar']")
	private WebElement calenderModule;
	
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leadsModule;
	
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organizationsrModule;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactsModule;
	
	@FindBy(xpath = "//a[text()='Opportunities']")
	private WebElement opportunatiesModule;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsModule;
	
	@FindBy(xpath = "//td[@class='small' and @valign='bottom'][1]")
	private WebElement administratorModule;
	
	
	public WebElement getAdministratorModule() {
		return administratorModule;
	}	
	public WebElement getCalenderModule() {
		return calenderModule;
	}
	public WebElement getLeadsModule() {
		return leadsModule;
	}
	public WebElement getOrganizationsrModule() {
		return organizationsrModule;
	}
	public WebElement getContactsModule() {
		return contactsModule;
	}
	public WebElement getOpportunatiesModule() {
		return opportunatiesModule;
	}
	public WebElement getProductsModule() {
		return productsModule;
	}
	
	
	
	
	

}
