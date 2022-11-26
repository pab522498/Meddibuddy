package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClasses.BaseClass;
import listenerClasses.ListenerClass;
import pomClasses.DeliveryPage;
import pomClasses.HomePage;

public class VerifyBuyTheTabletOrder {
	static WebDriver driver;
	HomePage hp;
	DeliveryPage dp;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest extentTest;
	
	@BeforeClass
	public void beforeClass() {
		htmlReporter = BaseClass.getExtentHtmlReporter();
		reports = BaseClass.getExtentreports();
		extentTest = BaseClass.getExtentTest("VerifyBuyTheTabletOrder");
		
		driver=BaseClass.getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		hp = new HomePage(driver);
		dp= new DeliveryPage(driver);
	}
	
	@Test(priority=1)
	public void buyTheMedicine() throws InterruptedException, IOException {
		dp.buyTheMedicine();
	}
	
	@Test(priority=2)
	public void verifyPersonalDetailPageIsOpened() throws InterruptedException, IOException {
		boolean personalDet = dp.goToPersonalDeatils();
		Assert.assertTrue(personalDet);
		dp.enterPersonalDetail();
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		reports.flush();
	}

}
