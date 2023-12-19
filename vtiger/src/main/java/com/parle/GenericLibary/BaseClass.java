package com.parle.GenericLibary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.parle.PomClasses.CreateProductPage;
import com.parle.PomClasses.HomePage;
import com.parle.PomClasses.LoginPage;
import com.parle.PomClasses.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	 public static WebDriver driver;
	 public PropertyUtill pu;
	 public WebDriverUtility wb;
	 public LoginPage lp;
	 public HomePage hp;
	 public ProductPage pp;
	 public CreateProductPage cpp;
	 public ExcelUtilities ex;
	 public JavaUtilities ju;
	 
	public static ThreadLocal<WebDriver> tl = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return tl.get();
	}
	public static void setDriver(WebDriver driver){
		tl.set(driver);
	}
	public static void removeDriver() {
		tl.remove();
	}
	 
	@BeforeClass
	public void openApp() {
		pu= new PropertyUtill();
		wb = new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		BaseClass.setDriver(driver);
		wb.maximizeBrowser(BaseClass.getDriver());
		wb.implicityWait(BaseClass.getDriver(), 10);
		wb.openAppicationWithGetMethod(BaseClass.getDriver(),pu.propertyFetch(Iconstant.vtigerPropertyPath, "url") );
	}
	
	@BeforeMethod 
	public void login() {
		pu= new PropertyUtill();
		lp = new LoginPage(BaseClass.getDriver());
		lp.getUserNameTextBox().sendKeys(pu.propertyFetch(Iconstant.vtigerPropertyPath, "un"));
		lp.getPasswordTextBox().sendKeys(pu.propertyFetch(Iconstant.vtigerPropertyPath, "pwd"));
		lp.getLoginButton().click();	 
	}
	
	
	@AfterMethod
	public void logout() {
		wb = new WebDriverUtility();
		hp = new HomePage(BaseClass.getDriver());
		wb.movetoElementPerform(BaseClass.getDriver(), hp.getAdministratorModule());
		lp = new LoginPage(BaseClass.getDriver());
		lp.getLogoutButton().click();;
	}
	
	@AfterClass
	public void CloseApp() {
		BaseClass.getDriver().close();
		if(BaseClass.getDriver()==null)
		{
			BaseClass.removeDriver();
		}
	}	
}
