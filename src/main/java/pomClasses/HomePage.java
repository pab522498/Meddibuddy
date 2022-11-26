package pomClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.UtilClass;

public class HomePage extends UtilClass {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='mm-chevron-down light-bold active-color']")
	private WebElement pinTab;
	
	@FindBy(xpath="//input[@aria-label='pincode']")
	private WebElement setPin;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitPin;
	
	@FindBy(xpath="//span[text()='Kolhapur 416119']")
	private WebElement correctAddress;
	
	@FindBy(xpath="//input[@placeholder='Search Medicines']")
	private WebElement searchMedicine;
	
	@FindBy(xpath="//div[@class='m-b-5 bold smdTxt']")
	private List<WebElement> listOfVitaminTablet;
	
	@FindBy(xpath="//div[@class='light-bold']")
	private List<WebElement> listOfTabletPrice;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public String putPin() throws InterruptedException, IOException {
		setPin.sendKeys("416119");
		submitPin.click();
		return correctAddress.getText();
	}
	
	public void listOfMedicine() throws IOException {
		searchMedicine.sendKeys("Vitamin D");
		searchMedicine.sendKeys(Keys.ENTER);
		
		List<String> listOfVitDTablet =new ArrayList<>();
		for(WebElement eachTabletName : listOfVitaminTablet ) {
			listOfVitDTablet.add(eachTabletName.getText());
		}
		System.out.println(listOfVitDTablet);
	}
	
	public void listOfPrice() {
		
		List<Integer> listOfTabPrice = new ArrayList<>();
		for(WebElement eachTabletPrice : listOfTabletPrice) {
			listOfTabPrice.add(Integer.parseInt(eachTabletPrice.getText().replaceAll("[^0-9]","")));
		}
		System.out.println(listOfTabPrice+" ");
		Collections.sort(listOfTabPrice);
		System.out.println("Lowest Price : "+listOfTabPrice.get(0));
	}

}
