package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testBase.BaseRoseNCaken;

public class RnC_RegisterPage extends BaseRoseNCaken
{
	public WebDriver driver;
	
	public RnC_RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnk_Register;	
	
	@FindBy(xpath ="//input[@id='name']")
	WebElement txt_Name;	
	
	@FindBy(xpath ="//form[@id='regform']//input[@id='usemail']")
	WebElement txt_Email;
	
	@FindBy(xpath ="//input[@id='usrcontno']")
	WebElement txt_Phone;
	
	@FindBy(xpath ="//form[@id='regform']//input[@id='usrpass']")
	WebElement txt_Password;
	
	@FindBy(xpath ="//input[@id='compass']")
	WebElement txt_Conf_Password;
	
	@FindBy(xpath ="//input[@id='useradd']")
	WebElement txt_Address;
	
	@FindBy(xpath ="//input[@id='cityname']")
	WebElement txt_City;
	
	@FindBy(xpath ="//input[@id='picode']")
	WebElement txt_Pincode;
	
	@FindBy(xpath ="//input[@id='state']")
	WebElement txt_State;
	
	@FindBy(xpath ="//select[@id='shcountry']")
	WebElement drop_Country;
	
	@FindBy(xpath ="//input[@id='terms']")
	WebElement btn_TermsNConditions;
	
	@FindBy(xpath ="//form[@id='regform']//input[@id='btwnreg']")
	WebElement btn_Register;	
	
	@FindBy(xpath ="//h4[normalize-space()='Thank You for joining us.']")
	WebElement msgConfirmation;
	
	public void clickRegisterLink()
	{
		lnk_Register.click();
	}		
	public void setName(String name)
	{
		txt_Name.sendKeys(name);
	}
    public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}	
	public void setTelephone(String telephone )
	{
		txt_Phone.sendKeys(telephone);
	}	
	public void setPassword(String paswd)
	{
		txt_Password.sendKeys(paswd);
	}	
	public void setConfirmPassword(String ConfPaswd )  
	{
		txt_Conf_Password.sendKeys(ConfPaswd);
	}
	public void setAddress(String Addres)
	{
		txt_Address.sendKeys(Addres);
	}	
	public void setCity(String city)
	{
		txt_City.sendKeys(city);
	}	
	public void setPincode(String pin)
	{
		txt_Pincode.sendKeys(pin);
	}	 
	public void setState(String state)
	{
		txt_State.sendKeys(state);
	}	
	public void countrytDropClick()
	{
		drop_Country.click();	
	}	
	public void countryDropdownSelect()
	{
		Select countryobj=new Select(drop_Country);
		countryobj.selectByValue("1");
	}
	public void setPolicy()
	{
		btn_TermsNConditions.click();
	}	
	public void clickBtnRegister()
	{
		
		btn_Register.submit();
	}
					
	public String getConfirmationMsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}	
}
