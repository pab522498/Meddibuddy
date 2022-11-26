package testClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClasses.BaseClass;
import listenerClasses.ListenerClass;
import pomClasses.HomePage;

public class VerifySearchTheMedicine {
	static WebDriver driver;
	HomePage hp;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest extentTest;
	
	@BeforeClass
	public void beforeClass() {
		
		htmlReporter = BaseClass.getExtentHtmlReporter();
		reports = BaseClass.getExtentreports();
		extentTest = BaseClass.getExtentTest("VerifySearchTheMedicine");
		
		driver=BaseClass.getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		hp = new HomePage(driver);
	}
	
	@Test(priority=1)
	public void enterThePin() throws InterruptedException, IOException {
		String correctPin = hp.putPin();
		Assert.assertEquals(correctPin,"Kolhapur 416119","Enter wrong pincode");
	}
	
	@Test(priority=2)
	public void verifyTabletListIsPrinted() throws IOException {
		hp.listOfMedicine();
	}
	
	@Test(priority=3)
	public void getLowestPriceOfTablet(){
		hp.listOfPrice();
	}
	
	@AfterMethod
	public void afterMethod(){
//		if(result.getStatus()==ITestResult.SUCCESS) {
//			extentTest.log(Status.PASS, "Test :"+ result.getName());
//		}else if(result.getStatus()==ITestResult.FAILURE) {
//			String path=hp.getScreenshot(driver,result.getName());
//			extentTest.log(Status.FAIL,"Test :"+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//		}else if(result.getStatus()==ITestResult.SKIP) {
//			extentTest.log(Status.SKIP,"Test :"+result.getName());
//		}

		}
	
	@AfterClass
	public void afterClass() {
		reports.flush();
	}

}
