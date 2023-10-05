 package com.parlr.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.parle.GenericLibary.BaseClass;
import com.parle.GenericLibary.ExcelUtilities;
import com.parle.GenericLibary.Iconstant;
import com.parle.GenericLibary.JavaUtilities;
import com.parle.PomClasses.CreateProductPage;
import com.parle.PomClasses.HomePage;
import com.parle.PomClasses.ProductPage;


@Listeners(com.parle.GenericLibary.Listner.class)
public class Tc1Test extends BaseClass  {
	
	@Test 
	public void tc1() throws Throwable {
		ju = new JavaUtilities();
		ex = new ExcelUtilities();
		hp = new HomePage(driver);
		pp = new ProductPage(driver);
		cpp = new CreateProductPage(driver);
		hp.getProductsModule().click();
		Thread.sleep(3000);
		pp.getcreateProductButton().click();	
		cpp.getProductNameTextBox().sendKeys(ex.singleData(Iconstant.vtigerExcelPath, 0, 0,"productModule")+ju.randomNumber(10000));
		cpp.getSaveButton().click();
	}

}
