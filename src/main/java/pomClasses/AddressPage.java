package pomClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilClasses.UtilClass;

public class AddressPage extends UtilClass {
	WebDriver driver;
	
	@FindBy(xpath="//img[@ng-if='!editAgeGender']")
	private WebElement profileIcon;
	
	@FindBy(xpath="//li[@ui-sref='app.insurancePage']")
	private WebElement profile;
	
	@FindBy(xpath="//div[@class='address-card add']")
	private WebElement addAddress;
	
	@FindBy(xpath="(//input[@type='text'])[8]")
	private List<WebElement> ListOfDetails;
	
	@FindBy(xpath="//select[@name='addressType']")
	private WebElement dropDown;
	
	@FindBy(xpath="//input[@type='number']")
	private WebElement phone;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	
	
	
	@FindBy(xpath="")
	private WebElement a;

	
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void addTheAddressIntial() throws InterruptedException {
		profileIcon.click();
		profile.click();
	Thread.sleep(2000);
	}
	
//	public void addAddressSymbol() {
//		explicitWait(driver,addAddress);
//		addAddress.click();
//	}
	
	public void addTheAddressFinal(List<String> addressDetail) throws InterruptedException {
		explicitWait(driver,addAddress);
		addAddress.click();
		for(int i=8; i<=13; i++) {
			driver.findElement(By.xpath("(//input[@type='text'])["+i+"]")).sendKeys(addressDetail.get(i-8));
		}
		Thread.sleep(1000);
		Select sel = new Select(dropDown);
		sel.selectByVisibleText("Home");
		Thread.sleep(1000);
		phone.sendKeys("8329131619");
		Thread.sleep(1000);
		submit.click();
		
	}

}
