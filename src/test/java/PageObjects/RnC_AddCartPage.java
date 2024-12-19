package PageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RnC_AddCartPage
{	
     WebDriver driver;    
     public RnC_AddCartPage(WebDriver driver)
     {
 		this.driver=driver;
 		PageFactory.initElements(driver, this);
 	}
     
	@FindBy(xpath = "//input[@id='freesrc']")
	WebElement txt_Search;
	
	@FindBy(xpath="//a[normalize-space()='Fondant Strawberry Cake']")
	WebElement Cake;
	
	@FindBy(xpath = "//img[@src='https://www.rosencakes.com/images/logo-light.png']")
	WebElement Logo;
		
	@FindBy(xpath="//div[@class='col-lg-5 col-md-5 col-sm-12 col-xs-12 ']//img[@class='img-responsive']")
	WebElement Screenshot;
	
	@FindBy(xpath = "//input[@id='availableopt1']")
	WebElement btn_Option;
		
	@FindBy(xpath="//input[@id='cakentype2']")
	WebElement btn_CakeType;
	
	@FindBy(xpath = "//select[@id='selcakesize']")
	WebElement drop_CakeSize;
	
	@FindBy(xpath = "//select[@id='ordqty']")
	WebElement drop_Quantity;
	
	@FindBy(xpath="//input[@id='calendar_datePicker']")
	WebElement Delivery_Date;
	
	@FindBy(xpath = "//select[@id='deltime']")
	WebElement drop_DeliveryTime;
	
	@FindBy(xpath = "//textarea[@id='msgoncake']")
	WebElement txt_Message;
	
	@FindBy(xpath = "//input[@id='btnOrder']")
	WebElement btn_Addcart;
	
	public void searchCake()
	{
		txt_Search.sendKeys("strawberry cake", Keys.ENTER);
		Cake.click();
	}
	
	public void Capture_Screenshot() throws IOException 
	{
		File src=Screenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./RnC_Folder/Cake.png"));
	}
	
	public void logo_Check() 
	{
		Boolean logo=Logo.isEnabled();
		if(logo) 
			System.out.println("Logo Present");
		else 		
			System.out.println("Logo not present");	
	}
	
	public void available_Option()
	{
		btn_Option.click();
	}
	
	public void size_Quantity()
	{
		Select size = new Select(drop_CakeSize);
		size.selectByVisibleText("1/2 KG");
		Select quantity = new Select(drop_Quantity);
		quantity.selectByValue("3");
	}
	
	public void selectdate() 
	{
		Delivery_Date.click();
		while(true) {
		WebElement monthyear=driver.findElement(By.xpath("//*[@id=\"currM\"]"));
		String monthtext=monthyear.getText();
		System.out.println(monthtext);
		
		if(monthtext.equalsIgnoreCase("December 2025")) {
			break;
		}else {
			driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
		}
		}
		
		List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"frmchk\"]/table[3]/tbody/tr[2]/td[3]/div/table/tbody/tr/td/span"));
		for(WebElement ele:list) {
			String day=ele.getText();
			if(day.equals("16")) {
				ele.click();
			}
		}
	}
	
	public void deliverytime()
	{
		Select delivery_time=new Select(drop_DeliveryTime);
		delivery_time.selectByValue("3:00 PM to 6:00 PM");
	}
	
	public void message() {
		txt_Message.sendKeys("Happy Birthday Dear");
	}
	
	public void Addtocart() {
		btn_Addcart.click();
	}
}
	

	
