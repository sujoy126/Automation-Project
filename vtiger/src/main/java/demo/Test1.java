package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.parle.GenericLibary.WebDriverUtility;

public class Test1 {
	
	public void m1() {
		WebDriverUtility dr = new WebDriverUtility();
		WebDriver d = new ChromeDriver();
		dr.openAppicationWithGetMethod(d, "https://www.zomato.com/");
		
	}

}
