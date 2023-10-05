package com.parle.GenericLibary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listner implements ITestListener  {
	
	ExtentTest test;
	ExtentSparkReporter esr;
	ExtentReports er;
	JavaUtilities ju;
	WebDriverUtility wb;
	
	

	public void onTestStart(ITestResult result) {
		String methodName = result.getName();
		Reporter.log("TEst case Started "+methodName);
		test = er.createTest(methodName);
		}

	public void onTestSuccess(ITestResult result) {
		String testCaseName = result.getName();
		Reporter.log("Test case Executed Sucessfully "+testCaseName, true);
		test.log(Status.PASS, "Test case Executed Sucessfully "+testCaseName);
	}

	public void onTestFailure(ITestResult result) {
		String testCaseName = result.getName();
		Reporter.log("Test case Failded "+testCaseName, true);
		test.log(Status.FAIL, "Test case Failed "+testCaseName);
		
		ju = new JavaUtilities();
		wb = new WebDriverUtility();
		String st = Iconstant.screenShotPath+"/"+ju.generateDate()+ju.generateTime()+ testCaseName+".png";
		wb.takeScreenShot(BaseClass.driver,st);
		
	}

	public void onTestSkipped(ITestResult result) {
		String testCaseName = result.getName();
		Reporter.log("Test case Skipped "+testCaseName, true);
		test.log(Status.SKIP, "Test case Executed Sucessfully "+testCaseName);
	}

	public void onStart(ITestContext context) {
		
		String testCaseName = context.getName();
		ju =new JavaUtilities();	
		String path = Iconstant.reportsPath+"/"+ju.generateDate()+ju.generateTime()+testCaseName+".html" ;
		esr = new ExtentSparkReporter(path);
		er = new ExtentReports();
		esr.config().setDocumentTitle("Result of TestCase");
		esr.config().setReportName("Sujoy");
		esr.config().setTheme(Theme.DARK);
		
		er.attachReporter(esr);
		
		er.setSystemInfo("Operating System used", "Window");
		er.setSystemInfo("Bit used", "64-BIt");
		er.setSystemInfo("System used", "HP");
		
	}

	public void onFinish(ITestContext context) {
		er.flush();
		
	}
	

}
