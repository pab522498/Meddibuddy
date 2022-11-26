package listenerClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import baseClasses.BaseClass;
import utilClasses.UtilClass;

public class ListenerClass implements ITestListener{
	ExtentTest extentTest;
	  public void onTestStart(ITestResult result) {
		  extentTest = BaseClass.getAllreadyExtentTestExist();
		  extentTest.log(Status.INFO,"Test : "+result.getName());  
		  System.out.println("Test started "+result.getName()+" From Listeners Class");
		  Reporter.log("Test started");
	
	  }
	  
	  public void onTestSuccess(ITestResult result) {
		  extentTest.log(Status.PASS,"Test : "+result.getName());
		  System.out.println("Test pass "+result.getName()+" From Listeners Class");
		  Reporter.log("Test pass");
	  }
	  
	  public void onTestFailure(WebDriver driver,ITestResult result) throws IOException {
		  String path =UtilClass.getScreenshot(driver,result.getName());
		  extentTest.log(Status.FAIL,"Test : "+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		  System.out.println("Test fail "+result.getName()+" From Listeners Class");
		  Reporter.log("Test fail");
	  }

	  public void onTestSkipped(ITestResult result) {
		  extentTest.log(Status.SKIP,"Test : "+result.getName());
		  System.out.println("Test skipped "+result.getName()+" From Listeners Class");
		  Reporter.log("Test skipped");
	  }


}
