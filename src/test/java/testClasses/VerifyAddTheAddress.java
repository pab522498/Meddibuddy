package testClasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClasses.BaseClass;
import listenerClasses.ListenerClass;
import pomClasses.AddressPage;
import pomClasses.DeliveryPage;
import pomClasses.HomePage;

public class VerifyAddTheAddress {
	
	static WebDriver driver;
	AddressPage ap;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest extentTest;
	
	@BeforeClass
	public void beforeClass() {
		htmlReporter = BaseClass.getExtentHtmlReporter();
		reports = BaseClass.getExtentreports();
		extentTest = BaseClass.getExtentTest("VerifyAddTheAddress");
		
		driver=BaseClass.getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		ap = new AddressPage(driver);
	}
	
	@Test(priority=1)
	public void AddAddressDetailsIntial() throws InterruptedException {
		ap.addTheAddressIntial();
	}
	
	@DataProvider(name="AddressData")
	public Object getData() {
		String [][] k = {{"Prashant Ashok Borade","416119","1","mudshingi","near khat karkhana","kolhapur"},{"Satish Vilas Patil","416005","2","uchgaon","near marath chauk","kolhapur"}};
		return k;
	}
	
	@Test(priority=2,dataProvider="AddressData")
	public void AddAddressDetails(String name,String pin, String flatNo,String area,String landMark,String city ) throws InterruptedException {		
		List<String> addressDetail = Arrays.asList(name,pin,flatNo,area,landMark,city);
		ap.addTheAddressFinal(addressDetail);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
		extentTest.log(Status.PASS, "Test :"+ result.getName());
	}else if(result.getStatus()==ITestResult.FAILURE) {
		String path=ap.getScreenshot(driver,result.getName());
		extentTest.log(Status.FAIL,"Test :"+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}else if(result.getStatus()==ITestResult.SKIP) {
		extentTest.log(Status.SKIP,"Test :"+result.getName());
	}
	
	}
	
	@AfterClass
	public void afterClass() {
		reports.flush();
	}

}
