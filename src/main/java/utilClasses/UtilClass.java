package utilClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {
	static WebDriver driver;
	
	public static void explicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void explicitWait(WebDriver driver,List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public static String getScreenshot(WebDriver driver,String methodName) throws IOException {
		String path = ""+methodName+".png";
		TakesScreenshot k = (TakesScreenshot)driver;
		File source = k.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileHandler.copy(source, destination);
		return path;
	}
	
	public static String getConfigData(String key) throws IOException {
		FileInputStream file = new FileInputStream("\\configuration\\config.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
	

}
