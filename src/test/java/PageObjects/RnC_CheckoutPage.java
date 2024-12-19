package PageObjects;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RnC_CheckoutPage 
{	
	
	WebDriver driver;	
	public  RnC_CheckoutPage (WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='couponval']")
	WebElement CoupenCode;
	
	@FindBy(xpath="//input[@value='Apply']")
	WebElement btn_CoupenApply;
	
	@FindBy(xpath="//*[@id=\"frmqtyu\"]/table[5]/tbody/tr/td[2]/table/tbody/tr[1]/td/a/b")
	WebElement placeorder;
	
	@FindBy(xpath = "//*[@id=\"regform\"]/input")
	WebElement btn_Submit;	
	
	@FindBy(xpath="//*[@id=\"btnbook\"]")
	WebElement btn_SubmitOrder;
	
	@FindBy(xpath="//input[@name='recname']")
	WebElement txt_ReciverName;
	
	@FindBy(xpath="//input[@name='recmobno']")
	WebElement txt_ReciverMobile;
	
	@FindBy(xpath="//input[@name='address1']")
	WebElement txt_ReciverAddress;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement txt_ReciverCity;
	
	@FindBy(xpath="//input[@name='zipcode']")
	WebElement txt_ReciverPinCode;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement txt_ReciverState;
	
	@FindBy(xpath="//select[@id='shcountry']")
	WebElement drop_setCountry;
	
	@FindBy(xpath="/html/body/header/div[1]/div/div[2]/p/a[4]")
	WebElement Logout;
		
	public void coupon() 
	{
		CoupenCode.sendKeys("fgvft65");
	}
	
	public void applyCoupen() {
		btn_CoupenApply.click();
	}
	
	public void warning() 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Popup message: " + alert.getText());
        alert.accept();
	}
	
	public void placeOrder() 
	{
		placeorder.click();
		btn_Submit.click();
		
	}
	
	public void receiverdetails() 
	{
		txt_ReciverName.sendKeys("Shinil");
		txt_ReciverMobile.sendKeys("9845163258");
		txt_ReciverAddress.sendKeys("Star House");
		txt_ReciverCity.sendKeys("Thrissur");
		txt_ReciverPinCode.sendKeys("684391");
		txt_ReciverState.sendKeys("Kerala");
	}
	
	public void Country() {
		Select country = new Select(drop_setCountry);
		country.selectByVisibleText("India");
	}
	
	public void OrderPlaced()
	{
		btn_SubmitOrder.click();
	}

	public void Logout() 
	{
		Logout.click();
	}

}
