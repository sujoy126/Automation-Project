package com.parlr.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.parle.GenericLibary.BaseClass;

import com.parle.GenericLibary.ExcelUtilities;
import com.parle.GenericLibary.Iconstant;
import com.parle.GenericLibary.JavaUtilities;
import com.parle.GenericLibary.WebDriverUtility;
import com.parle.PomClasses.CreateProductPage;
import com.parle.PomClasses.HomePage;
import com.parle.PomClasses.ProductPage;

@Listeners(com.parle.GenericLibary.Listner.class)
public class Tc2Test  extends BaseClass{
	@Test
	public void tc2() throws Throwable  {
		wb = new WebDriverUtility();
		ex = new ExcelUtilities();
		ju = new JavaUtilities();
		
		hp = new HomePage(driver);
		hp.getProductsModule().click();
		
		pp = new ProductPage(driver);
		pp.getcreateProductButton().click();
		
		cpp = new CreateProductPage(driver);
		cpp.getProductNameTextBox().sendKeys(ex.singleData(Iconstant.vtigerExcelPath, 0, 0, "productModule"));
		cpp.getPartNumberTextBox().sendKeys(ex.singleData(Iconstant.vtigerExcelPath, 0, 1, "productModule"));
		cpp.getSaveButton().click();
	    
	}
	

} 
