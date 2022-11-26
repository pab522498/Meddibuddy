package pomClasses;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.UtilClass;

public class DeliveryPage extends UtilClass  {
	static WebDriver driver;
	@FindBy(xpath="(//button[text()='Add'])[2]")
	private WebElement medicine;
	
	@FindBy(xpath="//div[@ng-click='proceed()']")
	private WebElement goToCart;
	
	@FindBy(xpath="//button[@ng-click='proceed()']")
	private WebElement checkOut;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement enterPhone;
	
	@FindBy(xpath="//button[@class='btn btn-primary loginBtn']")
	private WebElement otpClick;
	
	@FindBy(xpath="//input[@id='otp']")
	private WebElement enterOtp;
	
	@FindBy(xpath="//h2[text()='Booking Details']")
	private WebElement bookingDetails;
	
	@FindBy(xpath="//input[@name='patientName']")
	private WebElement patientName;
	
	@FindBy(xpath="//div[@class='radio']")
	private WebElement gender;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//img[@ng-if='!editAgeGender']")
	private WebElement profileIcon;
	
	@FindBy(xpath="//li[@ui-sref='app.insurancePage']")
	private WebElement profile;
	
	@FindBy(xpath="//div[@class='address-card add']")
	private WebElement addAddress;
		
	
	public DeliveryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void buyTheMedicine() throws InterruptedException, IOException {
		explicitWait(driver,medicine);
		medicine.click();
		goToCart.click();
		enterPhone.sendKeys("8329131619");
		otpClick.click();
		enterOtp.click();
		Thread.sleep(12000);
		goToCart.click();
		checkOut.click();
	}
	
	public boolean goToPersonalDeatils() {
		try {
			explicitWait(driver,bookingDetails);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public void enterPersonalDetail() throws InterruptedException, IOException {
		patientName.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		patientName.sendKeys("PRASHANT ASHOK BORADE");
		Thread.sleep(2000);
		gender.click();
		email.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		email.sendKeys("prashantborade321@gmail.com");
		gender.click();
	}
	
	public void addTheAddress() {
		profileIcon.click();
		profile.click();
		addAddress.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	}

